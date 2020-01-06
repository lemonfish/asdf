

package net.asdf.core.query.executor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;

/**
 * 원본 쿼리를 템플릿 엔진을 통해 가공한 후 실행한다.
 *
 * @author lemonfish@gmail.com
 *
 */
@Component("공통쿼리실행기")
public class DefaultCommonQueryExecutor extends AbstractQueryExecutor implements CommonQueryExecutor {

	@Resource(name="공통INSERT쿼리실행기")
	private InsertQueryExecutor insert;

	@Resource(name="공통SELECT쿼리실행기")
	private SelectQueryExecutor select;

	@Resource(name="공통UPDATE쿼리실행기")
	private UpdateQueryExecutor update;

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String)
	 */
	@Override
	public int insert(String sql) {
		return insert.insert(sql);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.lang.String)
	 */
	@Override
	public int insert(String sql, String value) {
		return insert.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int insert(String sql, Integer value) {
		return insert.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	public int insert(String sql, Long value) {
		return insert.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	public int insert(String sql, Float value) {
		return insert.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	public int insert(String sql, Double value) {
		return insert.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int insert(String sql, BigDecimal value) {
		return insert.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return insert.insertAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> int insert(String sql, T param) {
		return insert.insert(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insert(java.lang.String, java.util.Map)
	 */
	@Override
	public int insert(String sql, Map<String, Object> param) {
		return insert.insert(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param) {
		return insert.insertAndGet(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model, java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output) {
		return insert.insertAndGet(sql, param, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, net.asdf.core.model.Model, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return insert.insertAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return insert.insertAndGet(sql, param, outColumns);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultInsertQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return insert.insertAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql) {
		return select.one(sql);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return select.one(sql, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql, String value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> one(String sql, Integer value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Long)
	 */
	@Override
	public Map<String, Object> one(String sql, Long value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Float)
	 */
	@Override
	public Map<String, Object> one(String sql, Float value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Double)
	 */
	@Override
	public Map<String, Object> one(String sql, Double value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> one(String sql, BigDecimal value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Long value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return select.one(sql, param);
	}

	@Override
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return select.one(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return select.one(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.one(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#get(java.lang.String)
	 */
	@Override
	public Map<String, Object> get(String sql) {
		return select.get(sql);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#get(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return select.get(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.get(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#get(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		return select.get(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#get(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return select.get(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql) {
		return select.list(sql);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return select.list(sql, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, String value) {
		return select.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Integer value) {
		return select.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Long)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Long value) {
		return select.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Float)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Float value) {
		return select.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Double)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Double value) {
		return select.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, BigDecimal value) {
		return select.list(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, String value, Class<T> clazz) {
		return select.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Integer, java.lang.Class)
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
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Long, java.lang.Class)
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
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Float, java.lang.Class)
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
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.lang.Double, java.lang.Class)
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
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz) {
		return select.list(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return select.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return select.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.list(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return select.list(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.util.Map, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return select.list(sql, param, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows) {
		return select.list(sql, param, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return select.list(sql, param, clazz, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize,
			int maxRows) {
		return select.list(sql, param, clazz, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize) {
		return select.list(sql, param, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, int, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows) {
		return select.list(sql, param, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return select.list(sql, param, clazz, fetchSize);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @param fetchSize
	 * @param maxRows
	 * @return
	 * @see net.asdf.core.query.executor.DefaultSelectQueryExecutor#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize,
			int maxRows) {
		return select.list(sql, param, clazz, fetchSize, maxRows);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String)
	 */
	@Override
	public int update(String sql) {
		return update.update(sql);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.lang.String)
	 */
	@Override
	public int update(String sql, String param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int update(String sql, Integer param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.lang.Long)
	 */
	@Override
	public int update(String sql, Long param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.lang.Float)
	 */
	@Override
	public int update(String sql, Float param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.lang.Double)
	 */
	@Override
	public int update(String sql, Double param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int update(String sql, BigDecimal param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, String value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Integer value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Long value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Float value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Double value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param value
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return update.updateAndGet(sql, value, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, java.util.Map)
	 */
	@Override
	public int update(String sql, Map<String, Object> param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#update(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> int update(String sql, T param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param) {
		return update.updateAndGet(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model, java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output) {
		return update.updateAndGet(sql, param, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, net.asdf.core.model.Model, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return update.updateAndGet(sql, param, outColumns, output);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return update.updateAndGet(sql, param, outColumns);
	}

	/**
	 * @param sql
	 * @param param
	 * @param outColumns
	 * @param output
	 * @return
	 * @see net.asdf.core.query.executor.DefaultUpdateQueryExecutor#updateAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return update.updateAndGet(sql, param, outColumns, output);
	}

	@Override
	public int insertAndGet(String sql, Map<String, Object> param) {
		return insert.insertAndGet(sql,  param);
	}

	@Override
	public int updateAndGet(String sql, Map<String, Object> param) {
		return update.updateAndGet(sql, param);
	}

	public void setInsert(InsertQueryExecutor insert) {
		this.insert = insert;
	}

	public void setSelect(SelectQueryExecutor select) {
		this.select = select;
	}

	public void setUpdate(UpdateQueryExecutor update) {
		this.update = update;
	}

	@PostConstruct
	private void setup() {
		if(insert != null) {
			insert.setDatabaseType(this.databaseType);
			insert.setDataSource(공통데이터소스);
			insert.setDefaultNamedParameterJdbcTemplate(공통명명파라미터JDBC템플릿);
			insert.setTemplateEngine(공통쿼리템플릿엔진);
			insert.setRowMapper(공통행매퍼);
		}
		if(update != null) {
			update.setDatabaseType(this.databaseType);
			update.setDataSource(공통데이터소스);
			update.setDefaultNamedParameterJdbcTemplate(공통명명파라미터JDBC템플릿);
			update.setTemplateEngine(공통쿼리템플릿엔진);
			update.setRowMapper(공통행매퍼);
		}
		if(select != null) {
			select.setDatabaseType(this.databaseType);
			select.setDataSource(공통데이터소스);
			select.setDefaultNamedParameterJdbcTemplate(공통명명파라미터JDBC템플릿);
			select.setTemplateEngine(공통쿼리템플릿엔진);
			select.setRowMapper(공통행매퍼);
		}
	}
}