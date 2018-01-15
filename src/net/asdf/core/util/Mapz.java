
package net.asdf.core.util;

import java.util.HashMap;
import java.util.Map;

public class Mapz {

	/**
	 * 지정된 맵으로 부터 지정된 키를 복사
	 * @param target
	 * @param from
	 * @param keys
	 * @return
	 */
	public static <T> Map<String,T> copy(Map<String,T> target, Map<String,T> from, String ... keys){
		for(String key : keys) {
			target.put(key, from.get(key));
		}
		return target;
	}

	/**
	 * 지정된 맵으로 부터 지정된 키를 추출한 새로운 맵을 반환
	 * @param from
	 * @param keys
	 * @return
	 */
	public static <T> Map<String,T> copy(Map<String,T> from, String ... keys){
		Map<String, T> newone = new HashMap<>(keys.length);
		for(String key : keys) {
			newone.put(key, from.get(key));
		}
		return newone;
	}

	/**
	 * 키, 값, 키, 값 ... 을 맵으로 변환
	 * @param key 첫번째 키
	 * @param datas 첫번째값, 두번째키, 두번째값 순으로 나열된 맵으로 변환될 목록
	 * @return
	 */
	public static Map<String, Object> map(String key, Object ... datas){
		Map<String, Object> m = new HashMap<String, Object>(datas.length / 2 + 1);

		m.put(key, datas[0]);
		/* 키와 값 쌍으로 루프마다 인덱스를 2개 소모 */
		for(int i = 1; i < datas.length; i += 2) {
			m.put((String) datas[i], datas[i+1]);
		}
		return m;
	}

	/**
	 * 키, 값, 키, 값 ... 을 맵으로 변환
	 * @param datas 키, 값 순으로 나열된 맵으로 변환될 값 목록
	 * @return
	 */
	public static Map<String, Object> map(int size, Object ... datas){
		Map<String, Object> m = new HashMap<String, Object>(size);
		/* 키와 값 쌍으로 루프마다 인덱스를 2개 소모 */
		for(int i = 0; i < datas.length; i += 2) {
			m.put((String) datas[i], datas[i+1]);
		}
		return m;
	}


	public static Map<String, Object> put(Map<String, Object> target, Object ... datas){
		/* 키와 값 쌍으로 루프마다 인덱스를 2개 소모 */
		for(int i = 0; i < datas.length; i += 2) {
			target.put((String) datas[i], datas[i+1]);
		}
		return target;
	}
}