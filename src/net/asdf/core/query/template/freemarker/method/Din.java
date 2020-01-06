
package net.asdf.core.query.template.freemarker.method;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;
import net.asdf.core.query.template.freemarker.DynamicVariableAwareTool;
import net.asdf.core.query.template.freemarker.FreeMarkerQueryTool;

/**
 * in 절 처리를 위한 메서드<br>
 *
 * in 절에 들어갈 목록 문자열을 상수값을 선언할 경우 SQLIA(SQL Injection Attack)의 위험이 있고, 쿼리캐싱이 안됨.
 * <blockquote><pre>
 * $codes = "'CD1', 'CD2', 'CD3', ... "
 * select ... from ... where code in ($codes)
 * =&gt; select ... from ... where code in ('CD1', 'CD2', 'CD3' ...)
 * </pre></blockquote>
 *
 * 따라서 해당 값을 바인드변수로 변경하여 SQLIA를 방지하고 쿼리캐싱을 가능하게 함.
 * <blockquote><pre>
 * $codes = "'CD1', 'CD2', 'CD3', ... "
 * select ... from ... where code in (${q.din(codes, "codes")})
 * =&gt; select ... from ... where code in (:_din_codes0, :_din_codes1, :_din_codes2, ...)
 * </pre></blockquote>
 *
 * engine 설정의 method.dynamicin.maxcount 값을 조정하여<br>
 * in 절에 입력 가능한 파라미터의 갯수를 조절함. <strong>반드시 설정!</strong><br>
 * oracle의 경우 in 절에 대량의 파라미터 입력 시 overflow로 인해 시스템 장애가 발생하는 사례가 있었음.
 *
 *
 * @author lemonfish@gmail.com
 *
 */
@Component
public class Din implements FreeMarkerQueryTool, DynamicVariableAwareTool {

	private static Logger logger = LogManager.getLogger(Din.class);

	@Value("#{asdf['query.dynamicin.maxcount'] ?: 100}")
	private int maxCount;

	private Pattern pattern = Pattern.compile("(?:'[^']*'|[^,])+");

	private ThreadLocal<Map<String, Object>> dynamicVariableMap = new ThreadLocal<Map<String,Object>>();

	private String[] names = new String[] {"din"};

	@Override
	public String[] getNames() {
		return names;
	}

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {

		String commaSeparatedValues = ((TemplateScalarModel)arguments.get(0)).getAsString();
		String tag = null;
		if(arguments.size() > 1) {
			tag = ((TemplateScalarModel)arguments.get(1)).getAsString();
		}else {
			tag = UUID.randomUUID().toString().replaceAll("\\-", "");
		}

		if("".equals(commaSeparatedValues)) {
			return new SimpleScalar("''");
		}

		StringBuilder result = new StringBuilder(commaSeparatedValues.length() * 2);
		StringBuilder bindName = new StringBuilder("_din_" + tag);
		int preFixLoc = bindName.length();

		Matcher matcher = pattern.matcher(commaSeparatedValues);

		int valueCount = 0;
		Map<String,Object> m = dynamicVariableMap.get();

		while (matcher.find()) {
			if (valueCount >= maxCount) {
				logger.error("din parameter {} is maxsize({}) exceeded! ({})", tag, maxCount, valueCount);
			}
			bindName.append(valueCount);
			String value = commaSeparatedValues.substring(matcher.start(), matcher.end()).trim();
			if (value.charAt(0) == '\'') {
				value = value.substring(1, value.length());
			}
			if (value.charAt(value.length() - 1) == '\'') {
				value = value.substring(0, value.length() - 1);
			}
			result.append(":").append(bindName.toString()).append(',');

			m.put(bindName.toString(), value);
			bindName.setLength(preFixLoc);

			valueCount++;
		}

		result.setLength(result.length() - 1);

		return SimpleScalar.newInstanceOrNull(result.toString());
	}

	@Override
	public void setDynamicVariableMap(Map<String, Object> dynamicVariableMap) {
		this.dynamicVariableMap.set(dynamicVariableMap);
	}
}
