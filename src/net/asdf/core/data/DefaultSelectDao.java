

package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.CommonQueryExecutor;

@Component
public class DefaultSelectDao implements Dao {

	@Resource
	private CommonQueryExecutor queryExecutor;

	@Override
	public void setQueryExecutor(CommonQueryExecutor queryExecutor) {
		this.queryExecutor = queryExecutor;
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class, int, int)
	 */
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize,
			int maxRows) {
		return queryExecutor.list(sql, param, clazz, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class, int)
	 */
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return queryExecutor.list(sql, param, clazz, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, int, int)
	 */
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows) {
		return queryExecutor.list(sql, param, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, int)
	 */
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize) {
		return queryExecutor.list(sql, param, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize,
			int maxRows) {
		return queryExecutor.list(sql, param, clazz, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return queryExecutor.list(sql, param, clazz, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.util.Map, int, int)
	 */
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows) {
		return queryExecutor.list(sql, param, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.util.Map, int)
	 */
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return queryExecutor.list(sql, param, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return queryExecutor.list(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return queryExecutor.list(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return queryExecutor.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.util.Map)
	 */
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return queryExecutor.list(sql, param);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return queryExecutor.list(sql, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String)
	 */
	public List<Map<String, Object>> list(String sql) {
		return queryExecutor.list(sql);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#get(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return queryExecutor.get(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#get(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		return queryExecutor.get(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz) {
		return queryExecutor.get(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#get(java.lang.String, java.util.Map)
	 */
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return queryExecutor.get(sql, param);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#get(java.lang.String)
	 */
	public Map<String, Object> get(String sql) {
		return queryExecutor.get(sql);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return queryExecutor.one(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.util.Map)
	 */
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return queryExecutor.one(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, net.asdf.core.model.Model)
	 */
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return queryExecutor.one(sql, param);
	}

	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return queryExecutor.one(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return queryExecutor.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return queryExecutor.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return queryExecutor.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, Long value, Class<T> clazz) {
		return queryExecutor.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return queryExecutor.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return queryExecutor.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.math.BigDecimal)
	 */
	public Map<String, Object> one(String sql, BigDecimal value) {
		return queryExecutor.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Double)
	 */
	public Map<String, Object> one(String sql, Double value) {
		return queryExecutor.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Float)
	 */
	public Map<String, Object> one(String sql, Float value) {
		return queryExecutor.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Long)
	 */
	public Map<String, Object> one(String sql, Long value) {
		return queryExecutor.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Integer)
	 */
	public Map<String, Object> one(String sql, Integer value) {
		return queryExecutor.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.String)
	 */
	public Map<String, Object> one(String sql, String value) {
		return queryExecutor.one(sql, value);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String, java.lang.Class)
	 */
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return queryExecutor.one(sql, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#one(java.lang.String)
	 */
	public Map<String, Object> one(String sql) {
		return queryExecutor.one(sql);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz) {
		return queryExecutor.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, Double value, Class<T> clazz) {
		return queryExecutor.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, Float value, Class<T> clazz) {
		return queryExecutor.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, Long value, Class<T> clazz) {
		return queryExecutor.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz) {
		return queryExecutor.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.String, java.lang.Class)
	 */
	public <T extends Model> List<T> list(String sql, String value, Class<T> clazz) {
		return queryExecutor.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.math.BigDecimal)
	 */
	public List<Map<String, Object>> list(String sql, BigDecimal value) {
		return queryExecutor.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Double)
	 */
	public List<Map<String, Object>> list(String sql, Double value) {
		return queryExecutor.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Float)
	 */
	public List<Map<String, Object>> list(String sql, Float value) {
		return queryExecutor.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Long)
	 */
	public List<Map<String, Object>> list(String sql, Long value) {
		return queryExecutor.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.Integer)
	 */
	public List<Map<String, Object>> list(String sql, Integer value) {
		return queryExecutor.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.CommonQueryExecutor#list(java.lang.String, java.lang.String)
	 */
	public List<Map<String, Object>> list(String sql, String value) {
		return queryExecutor.list(sql, value);
	}

}
