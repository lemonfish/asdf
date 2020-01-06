

package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.executor.CommonQueryExecutor;

@Component("공통SELECT데이터접근기")
public class DefaultSelectDao implements SelectDao {

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

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, T, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize,
			int maxRows) {
		return 공통쿼리실행기.list(sql, param, clazz, fetchSize, maxRows);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, T, java.lang.Class, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return 공통쿼리실행기.list(sql, param, clazz, fetchSize);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, T, int, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows) {
		return 공통쿼리실행기.list(sql, param, fetchSize, maxRows);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, T, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize) {
		return 공통쿼리실행기.list(sql, param, fetchSize);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize,
			int maxRows) {
		return 공통쿼리실행기.list(sql, param, clazz, fetchSize, maxRows);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return 공통쿼리실행기.list(sql, param, clazz, fetchSize);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize, int maxRows) {
		return 공통쿼리실행기.list(sql, param, fetchSize, maxRows);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.util.Map, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return 공통쿼리실행기.list(sql, param, fetchSize);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return 공통쿼리실행기.list(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, T)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return 공통쿼리실행기.list(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.list(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql) {
		return 공통쿼리실행기.list(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#get(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return 공통쿼리실행기.get(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#get(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		return 공통쿼리실행기.get(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz) {
		return 공통쿼리실행기.get(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#get(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.get(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#get(java.lang.String)
	 */
	@Override
	public Map<String, Object> get(String sql) {
		return 공통쿼리실행기.get(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.one(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return 공통쿼리실행기.one(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return 공통쿼리실행기.one(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Long value, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> one(String sql, BigDecimal value) {
		return 공통쿼리실행기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Double)
	 */
	@Override
	public Map<String, Object> one(String sql, Double value) {
		return 공통쿼리실행기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Float)
	 */
	@Override
	public Map<String, Object> one(String sql, Float value) {
		return 공통쿼리실행기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Long)
	 */
	@Override
	public Map<String, Object> one(String sql, Long value) {
		return 공통쿼리실행기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> one(String sql, Integer value) {
		return 공통쿼리실행기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql, String value) {
		return 공통쿼리실행기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return 공통쿼리실행기.one(sql, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#one(java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql) {
		return 공통쿼리실행기.one(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Double value, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Float value, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Long value, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, String value, Class<T> clazz) {
		return 공통쿼리실행기.list(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, BigDecimal value) {
		return 공통쿼리실행기.list(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Double)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Double value) {
		return 공통쿼리실행기.list(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Float)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Float value) {
		return 공통쿼리실행기.list(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Long)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Long value) {
		return 공통쿼리실행기.list(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Integer value) {
		return 공통쿼리실행기.list(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.SelectDao#list(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, String value) {
		return 공통쿼리실행기.list(sql, value);
	}

}
