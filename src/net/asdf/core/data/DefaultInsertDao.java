
package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.CommonQueryExecutor;

@Component
public class DefaultInsertDao implements Dao {

	@Autowired
	private CommonQueryExecutor queryExecutor;

	@Override
	public void setQueryExecutor(CommonQueryExecutor queryExecutor) {
		this.queryExecutor = queryExecutor;
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return queryExecutor.insertAndGet(sql, param, outColumns);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model, java.lang.String[], java.util.Map)
	 */
	public <T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model, java.util.Map)
	 */
	public <T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, param, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> int insertAndGet(String sql, T param) {
		return queryExecutor.insertAndGet(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.util.Map)
	 */
	public int insert(String sql, Map<String, Object> param) {
		return queryExecutor.insert(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> int insert(String sql, T param) {
		return queryExecutor.insert(sql, param);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return queryExecutor.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.math.BigDecimal)
	 */
	public int insert(String sql, BigDecimal value) {
		return queryExecutor.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.lang.Double)
	 */
	public int insert(String sql, Double value) {
		return queryExecutor.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.lang.Float)
	 */
	public int insert(String sql, Float value) {
		return queryExecutor.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.lang.Long)
	 */
	public int insert(String sql, Long value) {
		return queryExecutor.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.lang.Integer)
	 */
	public int insert(String sql, Integer value) {
		return queryExecutor.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String, java.lang.String)
	 */
	public int insert(String sql, String value) {
		return queryExecutor.insert(sql, value);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#insert(java.lang.String)
	 */
	public int insert(String sql) {
		return queryExecutor.insert(sql);
	}

	public int insertAndGet(String sql, Map<String, Object> param) {
		return queryExecutor.insertAndGet(sql, param);
	}



}