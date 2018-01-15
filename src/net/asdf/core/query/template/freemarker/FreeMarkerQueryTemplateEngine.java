


package net.asdf.core.query.template.freemarker;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Component;

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
import net.asdf.core.query.SqlParameterSourceBuilder;
import net.asdf.core.query.template.QueryTemplateEngine;
import net.asdf.core.query.template.TemplateResult;
import net.asdf.core.web.SessionVariables;

@Component
public class FreeMarkerQueryTemplateEngine implements QueryTemplateEngine{

	private static Logger logger = LogManager.getLogger(FreeMarkerQueryTemplateEngine.class);


	@Value("#{config_template['singlevaluename' ?: 'value']}")
	private String singleValueName;

	@Value("#{config_template['sessionprefix' ?: 'S']}")
	private String sessionPrefix;

	@Value("#{config_template['encoding.input' ?: 'UTF-8']}")
	private String inputEncoding;

	@Value("#{config_template['encoding.output' ?: 'UTF-8']}")
	private String outputEncoding;

	@Autowired
	private List<FreeMarkerQueryTool> queryToolList;

	@Autowired
	private List<DynamicVariableAwareTool> dynamicVariableAwareToolList;

	private ObjectMapper mapper;

	private Configuration conf;

	private Map<String,TemplateMethodModelEx> toolContext;

	@Autowired
	private FreeMarkerQueryLoader queryLoader;

	@Autowired
	private SqlParameterSourceBuilder sqlParameterSourceBuilder;

	@Override
	@PostConstruct
	public void init() {

		conf = new Configuration(Configuration.VERSION_2_3_26);
		conf.setDefaultEncoding(this.inputEncoding);
		conf.setOutputEncoding(this.outputEncoding);
		conf.setLocalizedLookup(false);
		conf.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_26);
		builder.setForceLegacyNonListCollections(false);
		builder.setIterableSupport(true);
		builder.setDefaultDateType(TemplateDateModel.DATETIME);
		conf.setObjectWrapper(builder.build());
		conf.setTemplateLoader(queryLoader);

		mapper = new ObjectMapper();

		if(!queryToolList.isEmpty()) {
			toolContext = new HashMap<>(queryToolList.size());
			for(FreeMarkerQueryTool tool : queryToolList) {
				toolContext.put(tool.getName(), tool);
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
			/* TODO StringBuilderWriter를 풀링하는게 좋겠다 */
			StringBuilderWriter writer = new StringBuilderWriter(sql.length());

			Template tpl = conf.getTemplate(sql);
			tpl.process(contextMap, writer);

			templateResult.setSql(writer.toString());

			dynamicVariableMap.putAll(userContextMap);
			dynamicVariableMap.putAll(sessionContextMap);

			templateResult.setSqlParameterSource(sqlParameterSourceBuilder.build(dynamicVariableMap));

			logger.debug("{} result :\n{}\n{}", sql, templateResult.getSql(), templateResult.getSqlParameterSource());

			if(getKey) {

				Map<String, String> generatedColumnMap = new HashMap<>();
				if (param != null && Model.class.isAssignableFrom(param.getClass())) {

					for (Field field : param.getClass().getDeclaredFields()) {
						if (field.isAnnotationPresent(GenKey.class)) {
							GenKey genKey = field.getAnnotation(GenKey.class);
							if (StringUtils.isBlank(genKey.column)) {
								/* TODO 자동으로 컬럼명 생성할때 규칙을 좀 손봐야 하겠는데? */
								generatedColumnMap.put(field.getName().replaceAll("(.)([A-Z])", "$1_$2").toUpperCase(),
										field.getName());
							} else {
								generatedColumnMap.put(genKey.column, field.getName());
							}
						}

					}
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
		return queryLoader;
	}

	public void setQueryLoader(FreeMarkerQueryLoader queryLoader) {
		this.queryLoader = queryLoader;
	}



}