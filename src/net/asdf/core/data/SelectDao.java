package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import net.asdf.core.model.Model;

public interface SelectDao extends Dao{

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class, int, int)
	 */
	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize, int maxRows);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class, int)
	 */
	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize);

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, int, int)
	 */
	<T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows);

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, int)
	 */
	<T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize, int maxRows);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize);

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.util.Map, int, int)
	 */
	List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows);

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.util.Map, int)
	 */
	List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	<T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> List<Map<String, Object>> list(String sql, T param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.util.Map)
	 */
	List<Map<String, Object>> list(String sql, Map<String, Object> param);

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, Class<T> clazz);

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String)
	 */
	List<Map<String, Object>> list(String sql);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#get(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	<T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#get(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> Map<String, Object> get(String sql, T param);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	<T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#get(java.lang.String, java.util.Map)
	 */
	Map<String, Object> get(String sql, Map<String, Object> param);

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#get(java.lang.String)
	 */
	Map<String, Object> get(String sql);

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	<T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.util.Map)
	 */
	Map<String, Object> one(String sql, Map<String, Object> param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> Map<String, Object> one(String sql, T param);

	<T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	<T extends Model> T one(String sql, BigDecimal value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	<T extends Model> T one(String sql, Double value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	<T extends Model> T one(String sql, Float value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	<T extends Model> T one(String sql, Long value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	<T extends Model> T one(String sql, Integer value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	<T extends Model> T one(String sql, String value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.math.BigDecimal)
	 */
	Map<String, Object> one(String sql, BigDecimal value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Double)
	 */
	Map<String, Object> one(String sql, Double value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Float)
	 */
	Map<String, Object> one(String sql, Float value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Long)
	 */
	Map<String, Object> one(String sql, Long value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Integer)
	 */
	Map<String, Object> one(String sql, Integer value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.String)
	 */
	Map<String, Object> one(String sql, String value);

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String, java.lang.Class)
	 */
	<T extends Model> T one(String sql, Class<T> clazz);

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#one(java.lang.String)
	 */
	Map<String, Object> one(String sql);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, Double value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, Float value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, Long value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, Integer value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.String, java.lang.Class)
	 */
	<T extends Model> List<T> list(String sql, String value, Class<T> clazz);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.math.BigDecimal)
	 */
	List<Map<String, Object>> list(String sql, BigDecimal value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Double)
	 */
	List<Map<String, Object>> list(String sql, Double value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Float)
	 */
	List<Map<String, Object>> list(String sql, Float value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Long)
	 */
	List<Map<String, Object>> list(String sql, Long value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.Integer)
	 */
	List<Map<String, Object>> list(String sql, Integer value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#list(java.lang.String, java.lang.String)
	 */
	List<Map<String, Object>> list(String sql, String value);

}