

package net.asdf.core.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import net.asdf.core.model.Model;

public interface CommonQueryExecutor {

	int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output);

	int updateAndGet(String sql, Map<String, Object> param, String[] outColumns);

	<T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output);

	<T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output);

	<T extends Model> int updateAndGet(String sql, T param);

	<T extends Model> int update(String sql, T param);

	int update(String sql, Map<String, Object> param);

	int updateAndGet(String sql, BigDecimal value, Map<String, Object> output);

	int updateAndGet(String sql, Double value, Map<String, Object> output);

	int updateAndGet(String sql, Float value, Map<String, Object> output);

	int updateAndGet(String sql, Long value, Map<String, Object> output);

	int updateAndGet(String sql, Integer value, Map<String, Object> output);

	int updateAndGet(String sql, String value, Map<String, Object> output);

	int update(String sql, BigDecimal param);

	int update(String sql, Double param);

	int update(String sql, Float param);

	int update(String sql, Long param);

	int update(String sql, Integer param);

	int update(String sql, String param);

	int update(String sql);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize, int maxRows);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize);

	<T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows);

	<T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize, int maxRows);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize);

	List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows);

	List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize);

	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz);

	<T extends Model> List<Map<String, Object>> list(String sql, T param);

	List<Map<String, Object>> list(String sql, Map<String, Object> param);

	<T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Double value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Float value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Long value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Integer value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, String value, Class<T> clazz);

	List<Map<String, Object>> list(String sql, BigDecimal value);

	List<Map<String, Object>> list(String sql, Double value);

	List<Map<String, Object>> list(String sql, Float value);

	List<Map<String, Object>> list(String sql, Long value);

	List<Map<String, Object>> list(String sql, Integer value);

	List<Map<String, Object>> list(String sql, String value);

	<T extends Model> List<T> list(String sql, Class<T> clazz);

	List<Map<String, Object>> list(String sql);

	<T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz);

	<T extends Model> Map<String, Object> get(String sql, T param);

	<T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz);

	Map<String, Object> get(String sql, Map<String, Object> param);

	Map<String, Object> get(String sql);

	<T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz);

	Map<String, Object> one(String sql, Map<String, Object> param);

	<T extends Model> Map<String, Object> one(String sql, T param);

	<T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz);

	<T extends Model> T one(String sql, BigDecimal value, Class<T> clazz);

	<T extends Model> T one(String sql, Double value, Class<T> clazz);

	<T extends Model> T one(String sql, Float value, Class<T> clazz);

	<T extends Model> T one(String sql, Long value, Class<T> clazz);

	<T extends Model> T one(String sql, Integer value, Class<T> clazz);

	<T extends Model> T one(String sql, String value, Class<T> clazz);

	Map<String, Object> one(String sql, BigDecimal value);

	Map<String, Object> one(String sql, Double value);

	Map<String, Object> one(String sql, Float value);

	Map<String, Object> one(String sql, Long value);

	Map<String, Object> one(String sql, Integer value);

	Map<String, Object> one(String sql, String value);

	<T extends Model> T one(String sql, Class<T> clazz);

	Map<String, Object> one(String sql);

	int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output);

	int insertAndGet(String sql, Map<String, Object> param, String[] outColumns);

	<T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output);

	<T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output);

	<T extends Model> int insertAndGet(String sql, T param);

	int insert(String sql, Map<String, Object> param);

	<T extends Model> int insert(String sql, T param);

	int insertAndGet(String sql, BigDecimal value, Map<String, Object> output);

	int insertAndGet(String sql, Double value, Map<String, Object> output);

	int insertAndGet(String sql, Float value, Map<String, Object> output);

	int insertAndGet(String sql, Long value, Map<String, Object> output);

	int insertAndGet(String sql, Integer value, Map<String, Object> output);

	int insertAndGet(String sql, String value, Map<String, Object> output);

	int insert(String sql, BigDecimal value);

	int insert(String sql, Double value);

	int insert(String sql, Float value);

	int insert(String sql, Long value);

	int insert(String sql, Integer value);

	int insert(String sql, String value);

	int insert(String sql);

	int insertAndGet(String sql, Map<String, Object> param);

	int updateAndGet(String sql, Map<String, Object> param);

}
