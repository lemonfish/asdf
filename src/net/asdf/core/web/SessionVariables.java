

package net.asdf.core.web;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionVariables {

	public static final String SESSION_KEY = "BILLPOST_SESSION";

	private static final ThreadLocal<Map<String, Object>> VARIABLES = new ThreadLocal<Map<String, Object>>() {
		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
	};

	private static final ThreadLocal<HttpSession> NATIVESESSION = new ThreadLocal<HttpSession>();

	public static void set(String variableName, Object variableValue) {
		Map<String, Object> map = VARIABLES.get();
		map.put(variableName, variableValue);
		map.put("isDirty", true);
	}


	public static boolean isDirty() {
		Map<String, Object> map = VARIABLES.get();
		return (boolean) map.get("isDirty");
	}

	public static Object get(String variableName) {
		Map<String, Object> map = VARIABLES.get();
		return map.get(variableName);
	}

	public static Map<String, Object> getMap() {
		return Collections.unmodifiableMap(VARIABLES.get());
	}

	public static void popuplate(HttpSession nativeSession) {
		Map<String,Object> map = VARIABLES.get();

		NATIVESESSION.set(nativeSession);

		@SuppressWarnings("unchecked")
		Map<String,Object> sessionMap = (Map<String, Object>) nativeSession.getAttribute(SESSION_KEY);
		if(sessionMap == null) {
			sessionMap = new HashMap<>();
			nativeSession.setAttribute(SESSION_KEY, sessionMap);
		}

		for(String key : sessionMap.keySet()) {
			map.put(key, sessionMap.get(key));
		}

		map.put("isDirty", false);

	}

	public static void clear() {
		VARIABLES.get().clear();
		NATIVESESSION.remove();
	}


	public static void sync() {
		if(isDirty()) {
			Map<String,Object> map = VARIABLES.get();
			HttpSession nativeSession = NATIVESESSION.get();
			if(nativeSession != null) {
				@SuppressWarnings("unchecked")
				Map<String,Object> sessionMap = (Map<String, Object>) nativeSession.getAttribute(SESSION_KEY);
				if(sessionMap == null) {
					sessionMap = new HashMap<>();
				}
				sessionMap.putAll(map);
				sessionMap.remove("isDirty");
				nativeSession.setAttribute(SESSION_KEY, sessionMap);
			}
		}
	}


	public static void setNative(String variable, String value) {
		HttpSession nativeSession = NATIVESESSION.get();
		if(nativeSession != null) {
			nativeSession.setAttribute(variable, value);
		}
		Map<String,Object> map = VARIABLES.get();
		map.put(variable, value);
	}

	public static void set(SessionModel sessionModel) {
		Map<String,Object> map = VARIABLES.get();
		for (Field field : sessionModel.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(SessionProperty.class)) {
				field.setAccessible(true);
				try {
					map.put(field.getName(), field.get(sessionModel));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
					map.put(field.getName(), null);
				}
			}
		}
		map.put("isDirty", true);
	}

}