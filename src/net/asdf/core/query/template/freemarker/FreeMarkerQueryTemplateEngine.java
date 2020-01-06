package net.asdf.core.query.template.freemarker;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateDateModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateNotFoundException;
import net.asdf.core.event.QueryReloadEvent;
import net.asdf.core.event.ReloadEvent;
import net.asdf.core.exception.SysException;
import net.asdf.core.model.Model;
import net.asdf.core.model.annotation.GenKey;
import net.asdf.core.query.Query;
import net.asdf.core.query.parameter.CombinedSqlParameterSource;
import net.asdf.core.query.parameter.SqlParameterSourceBuilder;
import net.asdf.core.query.template.QueryTemplateEngine;
import net.asdf.core.query.template.TemplateResult;
import net.asdf.core.util.Mapz;
import net.asdf.core.web.SessionVariables;

@Component
public class FreeMarkerQueryTemplateEngine implements QueryTemplateEngine{

	private static Logger logger = LogManager.getLogger(FreeMarkerQueryTemplateEngine.class);


	@Value("#{asdf['query.singlevaluename'] ?: 'value'}")
	private String singleValueName;

	@Value("#{asdf['query.sessionprefix'] ?: 'S'}")
	private String sessionPrefix;

	@Value("#{asdf['query.encoding.input'] ?: 'UTF-8'}")
	private String inputEncoding;

	@Value("#{adsf['query.encoding.output'] ?: 'UTF-8'}")
	private String outputEncoding;

	@Resource
	private List<FreeMarkerQueryTool> queryToolList;

	@Resource
	private List<DynamicVariableAwareTool> dynamicVariableAwareToolList;

	private ObjectMapper mapper;

	private Configuration conf;

	private Map<String,TemplateMethodModelEx> toolContext;

	@Resource
	private FreeMarkerQueryLoader freeMarkerQueryLoader;

	@Resource
	private SqlParameterSourceBuilder sqlParameterSourceBuilder;

	@Override
	@PostConstruct
	public void init() {

		conf = new Configuration(Configuration.VERSION_2_3_28);
		conf.setDefaultEncoding(this.inputEncoding);
		conf.setOutputEncoding(this.outputEncoding);

		/* NOTE 로케일에 따라 다른 템플릿 파일 찾지 안도록 */
		conf.setLocalizedLookup(false);
		conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
		builder.setForceLegacyNonListCollections(false);
		builder.setIterableSupport(true);
		builder.setDefaultDateType(TemplateDateModel.DATETIME);
		conf.setObjectWrapper(builder.build());
		conf.setTemplateLoader(freeMarkerQueryLoader);

		mapper = new ObjectMapper();

		if(!queryToolList.isEmpty()) {
			toolContext = new HashMap<>(queryToolList.size());
			for(FreeMarkerQueryTool tool : queryToolList) {
				for(String toolName : tool.getNames()) {
					toolContext.put(toolName, tool);
				}
			}
		}
	}

	@Override
	public TemplateResult eval(String sql) {
		return eval(sql, null);
	}

	@Override
	public TemplateResult eval(String sql, Object param) {
		return eval(sql, param, false);
	}

	@Override
	public TemplateResult eval(String sql, Object param, boolean getKey){
		TemplateResult templateResult = new TemplateResult();

		/*
		 * [ 외부 컨텍스트 [ 툴 컨텍스트 [ 세션 컨텍스트 [ 유저 컨텍스트 ] ] ] ]
		 */

		Map<String, Object> contextMap = new HashMap<>();

		// 매크로나 디렉티브에서 동적으로 생성되는 변수 처리를 위한 저장공간

		Map<String, Object> dynamicVariableMap = new HashMap<String, Object>();

		for(DynamicVariableAwareTool tool : dynamicVariableAwareToolList) {
			tool.setDynamicVariableMap(dynamicVariableMap);
		}

		// 유저 컨텍스트
		Map<String, Object> userContextMap = getUserContextMap(param);
		contextMap.putAll(userContextMap);
		// 세션 컨텍스트
		Map<String, Object> sessionContextMap = getSessionContextMap();
		contextMap.putAll(sessionContextMap);
		// 툴 컨텍스트
		if(toolContext != null) {
			contextMap.put("q", toolContext);
		}



		try{
			/* TODO StringBuilderWriter를 풀링하는게 좋겠다. JDK에 있는 StringWriter는 내부적으로 StringBuffer를 쓴다. */
			StringBuilderWriter writer = new StringBuilderWriter(sql.length());

			Template tpl = conf.getTemplate(sql);
			tpl.process(contextMap, writer);

			templateResult.setSql(writer.toString());

			if(userContextMap.containsKey("__model__")) {
				dynamicVariableMap.putAll(sessionContextMap);
				templateResult.setSqlParameterSource(new CombinedSqlParameterSource(sqlParameterSourceBuilder.build(dynamicVariableMap), sqlParameterSourceBuilder.build(userContextMap.get("__model__"))));
			}else {
				dynamicVariableMap.putAll(userContextMap);
				dynamicVariableMap.putAll(sessionContextMap);
				templateResult.setSqlParameterSource(sqlParameterSourceBuilder.build(dynamicVariableMap));
			}

			logger.debug("{} result :\n{}\n", sql, templateResult.getSql());

			if(getKey) {

				Map<String, String> generatedColumnMap = new HashMap<>();
				if (param != null && Model.class.isAssignableFrom(param.getClass())) {

					ReflectionUtils.doWithFields(param.getClass(), field->{
						GenKey genKey = field.getAnnotation(GenKey.class);
						if(logger.isDebugEnabled()) {
							logger.debug("GenKey detected {}", field.getName());
						}
						if (StringUtils.isBlank(genKey.column())) {
							/* TODO 자동으로 컬럼명 생성할때 규칙을 좀 손봐야 하겠는데? */
							generatedColumnMap.put(field.getName().replaceAll("(.)([A-Z])", "$1_$2").toUpperCase(),
									field.getName());

							logger.debug("GenKey parsed {} {}", field.getName().replaceAll("(.)([A-Z])", "$1_$2").toUpperCase(), field.getName());
						} else {
							generatedColumnMap.put(genKey.column(), field.getName());
							logger.debug("GenKey parsed {} {}", genKey.column(), field.getName());
						}
					}, new FieldFilter() {
						@Override
						public boolean matches(Field field) {
							return field.isAnnotationPresent(GenKey.class);
						}
					});
					if (!generatedColumnMap.isEmpty()) {
						templateResult.setGeneratedKeyColumnMap(generatedColumnMap);
					}
				}
			}
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally {
			// 매크로나 디렉티브에서 동적으로 생성되는 변수 처리를 위한 저장공간 클리어
			for(DynamicVariableAwareTool tool : dynamicVariableAwareToolList) {
				tool.setDynamicVariableMap(null);
			}
		}

		return templateResult;
	}

	private Map<String, Object> getSessionContextMap() {

		Map<String, Object> sessionContextMap = new HashMap<>();

		if (!SessionVariables.getMap().isEmpty()) {
			sessionContextMap.put(sessionPrefix, SessionVariables.getMap());
		}else {
			sessionContextMap.put(sessionPrefix, Mapz.map("사용자아이디", "anonymous", "사용자명", "익명사용자"));
		}

		return sessionContextMap;
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> getUserContextMap(Object param) {

		Map<String, Object> userContextMap = Collections.emptyMap();
		if (param == null) {
			return userContextMap;
		}

		Class<?> clazz = param.getClass();
		boolean isSingleValue = false;
		Object singleValue = null;

		if (clazz.isArray() || List.class.isAssignableFrom(clazz)) {
			isSingleValue = true;
			singleValue = param;
		} else if (ClassUtils.isPrimitiveOrWrapper(clazz) || String.class.isAssignableFrom(clazz) || BigDecimal.class.isAssignableFrom(clazz)) {
			isSingleValue = true;
			singleValue = param;
		} else if (SqlParameterValue.class.isAssignableFrom(clazz)) {
			isSingleValue = true;
			singleValue = ((SqlParameterValue) param).getValue();
		} else if (Map.class.isAssignableFrom(clazz)) {
			userContextMap = (Map<String, Object>) param;
		} else if (Model.class.isAssignableFrom(clazz)) {
			userContextMap = mapper.convertValue(param, Map.class);
			userContextMap.put("__model__", param);
		} else {
			throw new SysException("지원하지 않는 유형의 파라미터입니다. : { %s }", clazz.getCanonicalName());
		}

		if (isSingleValue) {
			userContextMap = new HashMap<>(1);
			userContextMap.put(singleValueName, singleValue);
		}

		return userContextMap;
	}

	@EventListener
	public void queryReloaded(ReloadEvent<Query> event) {
		for (String queryId : ((QueryReloadEvent) event).getReloadedQueryIds()) {
			try {
				conf.removeTemplateFromCache(queryId);
			} catch (IOException e) {
				// TODO 로깅을 추가해야함.
				e.printStackTrace();
			}
		}
	}

	public SqlParameterSourceBuilder getSqlParameterSourceBuilder() {
		return sqlParameterSourceBuilder;
	}


	public FreeMarkerQueryLoader getQueryLoader() {
		return freeMarkerQueryLoader;
	}

	public void setQueryLoader(FreeMarkerQueryLoader freeMarkerQueryLoader) {
		this.freeMarkerQueryLoader = freeMarkerQueryLoader;
	}



}