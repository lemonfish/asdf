
package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;

@Component
public class DefaultCommonDao implements CommonDao {

	@Autowired
	private DefaultInsertDao c;
	@Autowired
	private DefaultUpdateDao u;
	@Autowired
	private DefaultSelectDao r;
	@Autowired
	private DefaultCallDao p;

	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return c.insertAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return c.insertAndGet(sql, param, outColumns);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return c.insertAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output) {
		return c.insertAndGet(sql, param, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param) {
		return c.insertAndGet(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.util.Map)
	 */
	@Override
	public int insert(String sql, Map<String, Object> param) {
		return c.insert(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insert(String sql, T param) {
		return c.insert(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return c.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return c.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return c.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return c.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return c.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return c.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int insert(String sql, BigDecimal value) {
		return c.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	public int insert(String sql, Double value) {
		return c.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	public int insert(String sql, Float value) {
		return c.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	public int insert(String sql, Long value) {
		return c.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int insert(String sql, Integer value) {
		return c.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.String)
	 */
	@Override
	public int insert(String sql, String value) {
		return c.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String)
	 */
	@Override
	public int insert(String sql) {
		return c.insert(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return u.updateAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return u.updateAndGet(sql, param, outColumns);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return u.updateAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output) {
		return u.updateAndGet(sql, param, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param) {
		return u.updateAndGet(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int update(String sql, T param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.util.Map)
	 */
	@Override
	public int update(String sql, Map<String, Object> param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return u.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Double value, Map<String, Object> output) {
		return u.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Float value, Map<String, Object> output) {
		return u.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Long value, Map<String, Object> output) {
		return u.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Integer value, Map<String, Object> output) {
		return u.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, String value, Map<String, Object> output) {
		return u.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int update(String sql, BigDecimal param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Double)
	 */
	@Override
	public int update(String sql, Double param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Float)
	 */
	@Override
	public int update(String sql, Float param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Long)
	 */
	@Override
	public int update(String sql, Long param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int update(String sql, Integer param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.String)
	 */
	@Override
	public int update(String sql, String param) {
		return u.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String)
	 */
	@Override
	public int update(String sql) {
		return u.update(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize,
			int maxRows) {
		return r.list(sql, param, clazz, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, java.lang.Class, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return r.list(sql, param, clazz, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, int, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows) {
		return r.list(sql, param, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize) {
		return r.list(sql, param, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize,
			int maxRows) {
		return r.list(sql, param, clazz, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return r.list(sql, param, clazz, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows) {
		return r.list(sql, param, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return r.list(sql, param, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return r.list(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return r.list(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return r.list(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return r.list(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return r.list(sql, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql) {
		return r.list(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return r.get(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		return r.get(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz) {
		return r.get(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return r.get(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String)
	 */
	@Override
	public Map<String, Object> get(String sql) {
		return r.get(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return r.one(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return r.one(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return r.one(sql, param);
	}

	@Override
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return r.one(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return r.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return r.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return r.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Long value, Class<T> clazz) {
		return r.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return r.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return r.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> one(String sql, BigDecimal value) {
		return r.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Double)
	 */
	@Override
	public Map<String, Object> one(String sql, Double value) {
		return r.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Float)
	 */
	@Override
	public Map<String, Object> one(String sql, Float value) {
		return r.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Long)
	 */
	@Override
	public Map<String, Object> one(String sql, Long value) {
		return r.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> one(String sql, Integer value) {
		return r.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql, String value) {
		return r.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return r.one(sql, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql) {
		return r.one(sql);
	}
	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz) {
		return r.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Double value, Class<T> clazz) {
		return r.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Float value, Class<T> clazz) {
		return r.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Long value, Class<T> clazz) {
		return r.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz) {
		return r.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, String value, Class<T> clazz) {
		return r.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, BigDecimal value) {
		return r.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Double)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Double value) {
		return r.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Float)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Float value) {
		return r.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Long)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Long value) {
		return r.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Integer value) {
		return r.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, String value) {
		return r.list(sql, value);
	}

	@Override
	public int insertAndGet(String sql, Map<String, Object> param) {
		return c.insertAndGet(sql, param);
	}
	@Override
	public int updateAndGet(String sql, Map<String, Object> param) {
		return u.updateAndGet(sql, param);
	}


}
