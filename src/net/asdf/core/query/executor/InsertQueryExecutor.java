package net.asdf.core.query.executor;

import java.math.BigDecimal;
import java.util.Map;

import net.asdf.core.model.Model;

public interface InsertQueryExecutor extends QueryExecutor {

	int insert(String sql);

	int insert(String sql, String value);

	int insert(String sql, Integer value);

	int insert(String sql, Long value);

	int insert(String sql, Float value);

	int insert(String sql, Double value);

	int insert(String sql, BigDecimal value);

	int insertAndGet(String sql, String value, Map<String, Object> output);

	int insertAndGet(String sql, Integer value, Map<String, Object> output);

	int insertAndGet(String sql, Long value, Map<String, Object> output);

	int insertAndGet(String sql, Float value, Map<String, Object> output);

	int insertAndGet(String sql, Double value, Map<String, Object> output);

	int insertAndGet(String sql, BigDecimal value, Map<String, Object> output);

	<T extends Model> int insert(String sql, T param);

	int insert(String sql, Map<String, Object> param);

	<T extends Model> int insertAndGet(String sql, T param);

	<T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output);

	<T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output);

	int insertAndGet(String sql, Map<String, Object> param, String[] outColumns);

	int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output);

	int insertAndGet(String sql, Map<String, Object> param);

}