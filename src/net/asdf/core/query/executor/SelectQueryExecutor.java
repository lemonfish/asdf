package net.asdf.core.query.executor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import net.asdf.core.model.Model;

public interface SelectQueryExecutor extends QueryExecutor {

	Map<String, Object> one(String sql);

	<T extends Model> T one(String sql, Class<T> clazz);

	Map<String, Object> one(String sql, String value);

	Map<String, Object> one(String sql, Integer value);

	Map<String, Object> one(String sql, Long value);

	Map<String, Object> one(String sql, Float value);

	Map<String, Object> one(String sql, Double value);

	Map<String, Object> one(String sql, BigDecimal value);

	<T extends Model> T one(String sql, String value, Class<T> clazz);

	<T extends Model> T one(String sql, Integer value, Class<T> clazz);

	<T extends Model> T one(String sql, Long value, Class<T> clazz);

	<T extends Model> T one(String sql, Float value, Class<T> clazz);

	<T extends Model> T one(String sql, Double value, Class<T> clazz);

	<T extends Model> T one(String sql, BigDecimal value, Class<T> clazz);

	<T extends Model> Map<String, Object> one(String sql, T param);

	<T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz);

	Map<String, Object> one(String sql, Map<String, Object> param);

	<T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz);

	Map<String, Object> get(String sql);

	Map<String, Object> get(String sql, Map<String, Object> param);

	<T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz);

	<T extends Model> Map<String, Object> get(String sql, T param);

	<T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz);

	List<Map<String, Object>> list(String sql);

	<T extends Model> List<T> list(String sql, Class<T> clazz);

	List<Map<String, Object>> list(String sql, String value);

	List<Map<String, Object>> list(String sql, Integer value);

	List<Map<String, Object>> list(String sql, Long value);

	List<Map<String, Object>> list(String sql, Float value);

	List<Map<String, Object>> list(String sql, Double value);

	List<Map<String, Object>> list(String sql, BigDecimal value);

	<T extends Model> List<T> list(String sql, String value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Integer value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Long value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Float value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Double value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz);

	List<Map<String, Object>> list(String sql, Map<String, Object> param);

	<T extends Model> List<Map<String, Object>> list(String sql, T param);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz);

	List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize);

	List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize, int maxRows);

	<T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize);

	<T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize, int maxRows);

}