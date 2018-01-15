
package net.asdf.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Stringz {

	private static ThreadLocal<Matcher> matcher = new ThreadLocal<Matcher>();
	private static ThreadLocal<List<String>> variables = new ThreadLocal<List<String>>();

	private static Pattern pattern = Pattern.compile("\\$\\{([^}]+)\\}");

	public static String concat(String ... strings) {
		StringBuilder sb = new StringBuilder();
		for(String string : strings) {
			if(string != null) {
				sb.append(string);
			}
		}
		return sb.toString();
	}
	
	public static String concat(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for(String string : list) {
			if(string != null) {
				sb.append(string);
			}
		}
		return sb.toString();		
	}
	
	public static String concatWith(String separator, String ... strings) {
		StringBuilder sb = new StringBuilder();
		for(String string : strings) {
			if(string != null) {
				sb.append(string).append(separator);
			}
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}	
	
	public static String concatWith(String separator, List<String> list) {
		StringBuilder sb = new StringBuilder();
		for(String string : list) {
			if(string != null) {
				sb.append(string).append(separator);
			}
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}	

	/**
	 * 문자열을 지정 맵으로 바인딩하여 출력
	 * @param template ${변수명} 을 선언한 문자열 템플릿
	 * @param valueMap ${변수명}에서 변수명을 키로 하는 값이 있는 맵
	 * @return
	 */
	public static String bind(String template, Map<String,?> valueMap) {
		Matcher m = matcher.get();
		List<String> v = variables.get();
		String result = template;
		if(m == null) {
			m = pattern.matcher(template);
			v = new ArrayList<String>();
			matcher.set(m);
			variables.set(v);
		}else {
			m.reset(template);
			v.clear();
		}

		while(m.find()) {
			for(int i = 1, len = m.groupCount(); i <= len; i++) {
				result = result.replaceAll("\\$\\{" + m.group(i) + "\\}", Matcher.quoteReplacement(valueMap.get(m.group(i)).toString()));
			}
		}
		return result;
	}
}