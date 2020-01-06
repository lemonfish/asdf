package net.asdf.core.query.executor;

import java.math.BigDecimal;
import java.util.Map;

import net.asdf.core.model.Model;

public interface UpdateQueryExecutor extends QueryExecutor {

	int update(String sql);

	int update(String sql, String param);

	int update(String sql, Integer param);

	int update(String sql, Long param);

	int update(String sql, Float param);

	int update(String sql, Double param);

	int update(String sql, BigDecimal param);

	int updateAndGet(String sql, String value, Map<String, Object> output);

	int updateAndGet(String sql, Integer value, Map<String, Object> output);

	int updateAndGet(String sql, Long value, Map<String, Object> output);

	int updateAndGet(String sql, Float value, Map<String, Object> output);

	int updateAndGet(String sql, Double value, Map<String, Object> output);

	int updateAndGet(String sql, BigDecimal value, Map<String, Object> output);

	int update(String sql, Map<String, Object> param);

	<T extends Model> int update(String sql, T param);

	<T extends Model> int updateAndGet(String sql, T param);

	<T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output);

	<T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output);

	int updateAndGet(String sql, Map<String, Object> param, String[] outColumns);

	int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output);

	int updateAndGet(String sql, Map<String, Object> param);

}