package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import net.asdf.core.model.Model;

public interface SelectService extends DefaultService {

	<T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz);

	<T extends Model> Map<String, Object> get(String sql, T param);

	Map<String, Object> get(String sql, Map<String, Object> param);

	Map<String, Object> get(String sql, String value);

	Map<String, Object> get(String sql, Integer value);

	Map<String, Object> get(String sql);

	/**
	 * 파라미터가 없는 단일 맵을 반환하는 쿼리를 실행한다.
	 * 결과가 없는 경우 예외(DataAccessException)가 발생한다.
	 * @return 맵
	 */
	Map<String, Object> getSimple();

	Map<String, Object> getSimple(Map<String, Object> param);

	<T extends Model> Map<String, Object> getSimple(T param);

	<T extends Model> T getSimple(Map<String, Object> param, Class<T> clazz);

	/**
	 * 모델이랑 모델 상속 클래스 받고 클래스 객체 반환
	 * @param param
	 * @param clazz
	 * @return
	 */
	<T extends Model, S extends Model> S getSimple(T param, Class<S> clazz);

	<T extends Model> List<T> list(String sql, Class<T> clazz);

	Map<String, Object> one(String sql);

	<T extends Model> T one(String sql, Class<T> clazz);

	Map<String, Object> one(String sql, Map<String, Object> param);

	<T extends Model> Map<String, Object> one(String sql, T param);

	<T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz);

	/**
	 * 맵이랑 모델 상속 클래스 받고 클래스 객체 반환
	 * @param param
	 * @param clazz
	 * @return
	 */
	<T extends Model> T oneSimple(Map<String, Object> param, Class<T> clazz);

	<T extends Model> T oneSimple(Model param, Class<T> clazz);

	<T extends Model> T oneSimple(Class<T> clazz);

	Map<String, Object> oneSimple();

	/**
	 * 모델 받고 맵 반환
	 * @param param
	 * @return
	 */
	<T extends Model> Map<String, Object> oneSimple(T param);

	/**
	 * 맵 받고 맵 반환
	 * 결과가 없는 경우 예외(DataAccessException)가 발생한다.
	 * @param param 조회조건
	 * @return 맵
	 */
	Map<String, Object> oneSimple(Map<String, Object> param);

	List<Map<String, Object>> listSimple();

	<T extends Model> List<T> listSimple(Class<T> clazz);

	List<Map<String, Object>> listSimple(Map<String, Object> param);

	<T extends Model> List<Map<String, Object>> listSimple(T param);

	<T extends Model> List<T> listSimple(Map<String, Object> param, Class<T> clazz);

	<T extends Model, S extends Model> List<S> listSimple(T param, Class<S> clazz);

	List<Map<String, Object>> list(String sql);

	<T extends Model> List<T> list(String sql, Integer value, Class<T> clazz);

	<T extends Model> List<Map<String, Object>> list(String sql, T param);

	List<Map<String, Object>> list(String sql, Map<String, Object> param);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz);

	Map<String, Object> oneSimple(String value);

	Map<String, Object> oneSimple(Integer value);

	Map<String, Object> oneSimple(Float value);

	Map<String, Object> oneSimple(Double value);

	Map<String, Object> oneSimple(BigDecimal value);

	Map<String, Object> one(String sql, String value);

	Map<String, Object> one(String sql, Integer value);

	Map<String, Object> one(String sql, Float value);

	Map<String, Object> one(String sql, Double value);

	Map<String, Object> one(String sql, BigDecimal value);

	<T extends Model> T one(String sql, String value, Class<T> clazz);

	<T extends Model> T one(String sql, Integer value, Class<T> clazz);

	<T extends Model> T one(String sql, Float value, Class<T> clazz);

	<T extends Model> T one(String sql, Double value, Class<T> clazz);

	<T extends Model> T one(String sql, BigDecimal value, Class<T> clazz);

	List<Map<String, Object>> listSimple(String value);

	List<Map<String, Object>> listSimple(Integer value);

	List<Map<String, Object>> listSimple(Float value);

	List<Map<String, Object>> listSimple(Double value);

	List<Map<String, Object>> listSimple(BigDecimal value);

	<T extends Model> List<T> listSimple(String value, Class<T> clazz);

	<T extends Model> List<T> listSimple(Integer value, Class<T> clazz);

	<T extends Model> List<T> listSimple(Float value, Class<T> clazz);

	<T extends Model> List<T> listSimple(Double value, Class<T> clazz);

	<T extends Model> List<T> listSimple(BigDecimal value, Class<T> clazz);

	<T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz);

}