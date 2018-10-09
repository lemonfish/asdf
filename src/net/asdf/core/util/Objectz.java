

package net.asdf.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Objectz {

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 모두 널이 아닌가?
	 * @param objects
	 * @return
	 */
	@SafeVarargs
	public static <T> boolean isNotNull(T ...objects) {
		for (T object : objects) {
			if(object == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 모두 널인가?
	 * @param objects
	 * @return
	 */
	@SafeVarargs
	public static <T> boolean isNull(T ...objects) {
		for (T object : objects) {
			if(object != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 널이 아닌게 하나라도 있는가?
	 * @param objects
	 * @return
	 */
	@SafeVarargs
	public static <T> boolean hasNotNull(T ...objects) {
		return !isNull(objects);

	}

	/**
	 * 널이 하나라도 있는가?
	 * @param objects
	 * @return
	 */
	@SafeVarargs
	public static <T> boolean hasNull(T ...objects) {
		return !isNotNull(objects);
	}

	public static <T> String toJson(T object) throws JsonProcessingException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

	public static <T> T nvl(T object, T defaultObject) {
		return object == null ? defaultObject : object;
	}

	@SafeVarargs
	public static <T> T nvls(T ...objects) {
		for(T obj : objects) {
			if(obj != null) {
				return obj;
			}
		}
		return null;
	}

	public static <T> T nvl2(T object, T notnullObject, T nullObject) {
		return object == null ? nullObject : notnullObject;
	}


	public static void main(String[] args) {
		assert Objectz.isNotNull("1", "123");
		assert Objectz.isNotNull(null, "123") == false;
		assert Objectz.isNull(null, "123") == false;
		assert Objectz.hasNull(null, "hello");
		assert Objectz.hasNull("hello") == false;
		assert Objectz.hasNotNull("hello");
	}
}