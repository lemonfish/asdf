package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.Map;

import net.asdf.core.model.Model;

public interface InsertDao extends Dao{

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	int insertAndGet(String sql, Map<String, Object> param, String[] outColumns);

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model, java.lang.String[], java.util.Map)
	 */
	<T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model, java.util.Map)
	 */
	<T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> int insertAndGet(String sql, T param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.util.Map)
	 */
	int insert(String sql, Map<String, Object> param);

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, net.asdf.core.model.Model)
	 */
	<T extends Model> int insert(String sql, T param);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	int insertAndGet(String sql, BigDecimal value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	int insertAndGet(String sql, Double value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	int insertAndGet(String sql, Float value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	int insertAndGet(String sql, Long value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	int insertAndGet(String sql, Integer value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	int insertAndGet(String sql, String value, Map<String, Object> output);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.math.BigDecimal)
	 */
	int insert(String sql, BigDecimal value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.lang.Double)
	 */
	int insert(String sql, Double value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.lang.Float)
	 */
	int insert(String sql, Float value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.lang.Long)
	 */
	int insert(String sql, Long value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.lang.Integer)
	 */
	int insert(String sql, Integer value);

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String, java.lang.String)
	 */
	int insert(String sql, String value);

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.CommonQueryExecutor#insert(java.lang.String)
	 */
	int insert(String sql);

	int insertAndGet(String sql, Map<String, Object> param);

}