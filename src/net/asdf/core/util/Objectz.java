

package net.asdf.core.util;

public class Objectz {


	/**
	 * 모두 널이 아닌가?
	 * @param objects
	 * @return
	 */
	public static boolean isNotNull(Object ...objects) {
		for (Object object : objects) {
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
	public static boolean isNull(Object ...objects) {
		for (Object object : objects) {
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
	public static boolean hasNotNull(Object ...objects) {
		return !isNull(objects);

	}

	/**
	 * 널이 하나라도 있는가?
	 * @param objects
	 * @return
	 */
	public static boolean hasNull(Object ...objects) {
		return !isNotNull(objects);
	}

}