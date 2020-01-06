
package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.executor.CommonQueryExecutor;

@Component("공통데이터접근기")
public class DefaultCommonDao implements CommonDao {

	private Logger logger = LogManager.getLogger(this);

	@Resource
	private CommonQueryExecutor 공통쿼리실행기;

	private boolean 쿼리실행기직접설정;

	@Override
	public void setQueryExecutor(CommonQueryExecutor queryExecutor) {
		if(!쿼리실행기직접설정) {
			this.공통쿼리실행기 = queryExecutor;
			쿼리실행기직접설정 = true;
		}else {
			logger.warn("직접설정된 쿼리실행기를 변경할 수 없습니다.");
		}
	}

	@Resource(name="공통INSERT데이터접근기")
	private InsertDao insert;

	@Resource(name="공통UPDATE데이터접근기")
	private UpdateDao update;

	@Resource(name="공통SELECT데이터접근기")
	private SelectDao select;

	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return insert.insertAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return insert.insertAndGet(sql, param, outColumns);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return insert.insertAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output) {
		return insert.insertAndGet(sql, param, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param) {
		return insert.insertAndGet(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.util.Map)
	 */
	@Override
	public int insert(String sql, Map<String, Object> param) {
		return insert.insert(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insert(String sql, T param) {
		return insert.insert(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int insert(String sql, BigDecimal value) {
		return insert.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	public int insert(String sql, Double value) {
		return insert.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	public int insert(String sql, Float value) {
		return insert.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	public int insert(String sql, Long value) {
		return insert.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int insert(String sql, Integer value) {
		return insert.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String, java.lang.String)
	 */
	@Override
	public int insert(String sql, String value) {
		return insert.insert(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#insert(java.lang.String)
	 */
	@Override
	public int insert(String sql) {
		return insert.insert(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return update.updateAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return update.updateAndGet(sql, param, outColumns);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return update.updateAndGet(sql, param, outColumns, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output) {
		return update.updateAndGet(sql, param, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param) {
		return update.updateAndGet(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int update(String sql, T param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.util.Map)
	 */
	@Override
	public int update(String sql, Map<String, Object> param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Double value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Float value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Long value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Integer value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#updateAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, String value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int update(String sql, BigDecimal param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Double)
	 */
	@Override
	public int update(String sql, Double param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Float)
	 */
	@Override
	public int update(String sql, Float param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Long)
	 */
	@Override
	public int update(String sql, Long param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int update(String sql, Integer param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String, java.lang.String)
	 */
	@Override
	public int update(String sql, String param) {
		return update.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#update(java.lang.String)
	 */
	@Override
	public int update(String sql) {
		return update.update(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, int, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Model param, int fetchSize, int maxRows) {
		return select.list(sql, param, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Model param, int fetchSize) {
		return select.list(sql, param, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize,
			int maxRows) {
		return select.list(sql, param, clazz, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return select.list(sql, param, clazz, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows) {
		return select.list(sql, param, fetchSize, maxRows);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return select.list(sql, param, fetchSize);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.list(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, T)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Model param) {
		return select.list(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return select.list(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return select.list(sql, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#list(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql) {
		return select.list(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return select.get(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		return select.get(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.get(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return select.get(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#get(java.lang.String)
	 */
	@Override
	public Map<String, Object> get(String sql) {
		return select.get(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.one(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return select.one(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return select.one(sql, param);
	}

	@Override
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return select.one(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Long value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> one(String sql, BigDecimal value) {
		return select.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Double)
	 */
	@Override
	public Map<String, Object> one(String sql, Double value) {
		return select.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Float)
	 */
	@Override
	public Map<String, Object> one(String sql, Float value) {
		return select.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Long)
	 */
	@Override
	public Map<String, Object> one(String sql, Long value) {
		return select.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> one(String sql, Integer value) {
		return select.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql, String value) {
		return select.one(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return select.one(sql, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.data.CommonDao#one(java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql) {
		return select.one(sql);
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
		return select.list(sql, value, clazz);
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
		return select.list(sql, value, clazz);
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
		return select.list(sql, value, clazz);
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
		return select.list(sql, value, clazz);
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
		return select.list(sql, value, clazz);
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
		return select.list(sql, value, clazz);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, BigDecimal value) {
		return select.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Double)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Double value) {
		return select.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Float)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Float value) {
		return select.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Long)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Long value) {
		return select.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Integer value) {
		return select.list(sql, value);
	}
	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.data.DefaultSelectDao#list(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, String value) {
		return select.list(sql, value);
	}

	@Override
	public int insertAndGet(String sql, Map<String, Object> param) {
		return insert.insertAndGet(sql, param);
	}
	@Override
	public int updateAndGet(String sql, Map<String, Object> param) {
		return update.updateAndGet(sql, param);
	}

	public void setInsert(InsertDao insert) {
		this.insert = insert;
	}
	public void setUpdate(UpdateDao update) {
		this.update = update;
	}
	public void setSelect(SelectDao select) {
		this.select = select;
	}

	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize,
			int maxRows) {
		return select.list(sql, param, clazz, fetchSize, maxRows);
	}
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return select.list(sql, param, clazz, fetchSize);
	}
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return select.list(sql, param, clazz);
	}

	@PostConstruct
	private void setup() {
		if(insert != null) {
			insert.setQueryExecutor(this.공통쿼리실행기);
		}
		if(update != null) {
			update.setQueryExecutor(this.공통쿼리실행기);
		}
		if(select != null) {
			select.setQueryExecutor(this.공통쿼리실행기);
		}
	}

}
