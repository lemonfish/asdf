package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.Map;

import net.asdf.core.model.Model;

public interface UpdateDao extends Dao{

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	int updateAndGet(String sql, Map<String, Object> param, String[] outColumns);

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model, java.lang.String[], java.util.Map)
	 */
	<T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model, java.util.Map)
	 */
	<T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> int updateAndGet(String sql, T param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> int update(String sql, T param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.util.Map)
	 */
	int update(String sql, Map<String, Object> param);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	int updateAndGet(String sql, BigDecimal value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	int updateAndGet(String sql, Double value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	int updateAndGet(String sql, Float value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	int updateAndGet(String sql, Long value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	int updateAndGet(String sql, Integer value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	int updateAndGet(String sql, String value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.math.BigDecimal)
	 */
	int update(String sql, BigDecimal param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.lang.Double)
	 */
	int update(String sql, Double param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.lang.Float)
	 */
	int update(String sql, Float param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.lang.Long)
	 */
	int update(String sql, Long param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.lang.Integer)
	 */
	int update(String sql, Integer param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String, java.lang.String)
	 */
	int update(String sql, String param);

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#update(java.lang.String)
	 */
	int update(String sql);

	int updateAndGet(String sql, Map<String, Object> param);

}