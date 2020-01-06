package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.Map;

import net.asdf.core.model.Model;

public interface InsertService extends DefaultService {

	/**
	 * 파라미터가 없는 기본 쿼리를 실행한다.
	 * 요청주소에 따라 쿼리아이디를 자동 생성한다.
	 * @return 영향받은 행수
	 */
	int insertSimple();

	int insertSimple(Map<String, Object> param);

	<T extends Model> int insertSimple(T param);

	int insertSimple(String value);

	int insertSimple(Integer value);

	int insertSimple(Long value);

	int insertSimple(Float value);

	int insertSimple(Double value);

	int insertSimple(BigDecimal value);

	<T extends Model> int insertAndGetSimple(T param);

	int insertAndGetSimple(Map<String, Object> param, String[] columns);

	int insert(String sql);

	int insert(String sql, String value);

	int insert(String sql, Integer value);

	int insert(String sql, Long value);

	int insert(String sql, Float value);

	int insert(String sql, Double value);

	int insert(String sql, BigDecimal value);

	<T extends Model> int insert(String sql, T param);

	<T extends Model> int insertAndGet(String sql, T param);

	int insertAndGet(String sql, Map<String, Object> param, String[] columns);

	int insert(String sql, Map<String, Object> param);

	int insert(String sql, Map<String, Object> param, String[] columns);

}