
package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.CommonQueryExecutor;

@Component
public class DefaultUpdateDao implements Dao {

	@Resource
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
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return queryExecutor.updateAndGet(sql, param, outColumns);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model, java.lang.String[], java.util.Map)
	 */
	public <T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model, java.util.Map)
	 */
	public <T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, param, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> int updateAndGet(String sql, T param) {
		return queryExecutor.updateAndGet(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> int update(String sql, T param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.util.Map)
	 */
	public int update(String sql, Map<String, Object> param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	public int updateAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	public int updateAndGet(String sql, Double value, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	public int updateAndGet(String sql, Float value, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	public int updateAndGet(String sql, Long value, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	public int updateAndGet(String sql, Integer value, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#updateAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	public int updateAndGet(String sql, String value, Map<String, Object> output) {
		return queryExecutor.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.math.BigDecimal)
	 */
	public int update(String sql, BigDecimal param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.lang.Double)
	 */
	public int update(String sql, Double param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.lang.Float)
	 */
	public int update(String sql, Float param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.lang.Long)
	 */
	public int update(String sql, Long param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.lang.Integer)
	 */
	public int update(String sql, Integer param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String, java.lang.String)
	 */
	public int update(String sql, String param) {
		return queryExecutor.update(sql, param);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#update(java.lang.String)
	 */
	public int update(String sql) {
		return queryExecutor.update(sql);
	}

	public int updateAndGet(String sql, Map<String, Object> param) {
		return queryExecutor.updateAndGet(sql, param);
	}


}

