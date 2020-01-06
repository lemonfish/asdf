
package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import net.asdf.core.data.CommonDao;
import net.asdf.core.jdbc.transaction.NoTx;
import net.asdf.core.model.Model;
import net.asdf.core.query.QueryIdGenerator;

@Component("공통SELECT서비스")
public class DefaultSelectService implements SelectService {

	private Logger logger = LogManager.getLogger(this);

	@Resource
	private CommonDao 공통데이터접근기;

	private boolean 데이터접근기직접설정;

	@Resource
	private QueryIdGenerator 쿼리아이디생성기;

	private boolean 쿼리아이디생성기직접설정;


	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#setCommonDao(net.asdf.core.data.CommonDao)
	 */
	@Override
	public void setCommonDao(CommonDao commonDao) {
		if(!데이터접근기직접설정) {
			this.공통데이터접근기 = commonDao;
			데이터접근기직접설정 = true;
		}else {
			logger.warn("직접설정된 데이터접근기를 변경할 수 없습니다.");
		}
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#setQueryIdGenerator(net.asdf.core.query.QueryIdGenerator)
	 */
	@Override
	public void setQueryIdGenerator(QueryIdGenerator queryIdGenerator) {
		if(!쿼리아이디생성기직접설정) {
			this.쿼리아이디생성기 = queryIdGenerator;
			쿼리아이디생성기직접설정 = true;
		}else {
			logger.warn("직접설정된 쿼리아이디생성기는 변경할 수 없습니다.");
		}
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#get(java.lang.String, T, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		List<S> list = 공통데이터접근기.list(sql, param, clazz);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#get(java.lang.String, T)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		List<Map<String, Object>> list = 공통데이터접근기.list(sql, param);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#get(java.lang.String, java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		List<Map<String, Object>> list = 공통데이터접근기.list(sql, param);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#get(java.lang.String, java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> get(String sql, String value) {
		List<Map<String, Object>> list = 공통데이터접근기.list(sql, value);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#get(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NoTx
	public Map<String, Object> get(String sql, Integer value) {
		List<Map<String, Object>> list = 공통데이터접근기.list(sql, value);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#get(java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> get(String sql) {
		List<Map<String, Object>> list = 공통데이터접근기.list(sql);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#getSimple()
	 */
	@Override
	@NoTx
	public Map<String,Object> getSimple() {
		return 공통데이터접근기.get(쿼리아이디생성기.generate());
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#getSimple(java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> getSimple(Map<String, Object> param) {
		return 공통데이터접근기.get(쿼리아이디생성기.generate(), param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#getSimple(T)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> getSimple(T param) {
		return 공통데이터접근기.get(쿼리아이디생성기.generate(), param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#getSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T getSimple(Map<String, Object> param, Class<T> clazz) {
		return 공통데이터접근기.get(쿼리아이디생성기.generate(), param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#getSimple(T, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> S getSimple(T param, Class<S> clazz) {
		return this.get(쿼리아이디생성기.generate(), param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return 공통데이터접근기.list(sql, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql) {
		return 공통데이터접근기.one(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return 공통데이터접근기.one(sql, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return 공통데이터접근기.one(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, T)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return 공통데이터접근기.one(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return 공통데이터접근기.one(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T oneSimple(Map<String, Object> param, Class<T> clazz) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T oneSimple(Model param, Class<T> clazz) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T oneSimple(Class<T> clazz) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple()
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple() {
		return 공통데이터접근기.one(쿼리아이디생성기.generate());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(T)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> oneSimple(T param) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Map<String, Object> param) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple()
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple() {
		return 공통데이터접근기.list(쿼리아이디생성기.generate());
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.util.Map)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Map<String, Object> param) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(T)
	 */
	@Override
	@NoTx
	public <T extends Model> List<Map<String, Object>> listSimple(T param) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Map<String, Object> param, Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(T, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> List<S> listSimple(T param, Class<S> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> list(String sql) {
		return 공통데이터접근기.list(sql);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz) {
		return 공통데이터접근기.list(sql, value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String, T)
	 */
	@Override
	@NoTx
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return 공통데이터접근기.list(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String, java.util.Map)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return 공통데이터접근기.list(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return 공통데이터접근기.list(sql, param, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#list(java.lang.String, T, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return 공통데이터접근기.list(sql, param, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(String value) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.lang.Integer)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Integer value) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.lang.Float)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Float value) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.lang.Double)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Double value) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#oneSimple(java.math.BigDecimal)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(BigDecimal value) {
		return 공통데이터접근기.one(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, String value) {
		return 공통데이터접근기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Integer value) {
		return 공통데이터접근기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Float)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Float value) {
		return 공통데이터접근기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Double)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Double value) {
		return 공통데이터접근기.one(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, BigDecimal value) {
		return 공통데이터접근기.one(sql, value);
	}



	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return 공통데이터접근기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return 공통데이터접근기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return 공통데이터접근기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return 공통데이터접근기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return 공통데이터접근기.one(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.String)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(String value) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Integer)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Integer value) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Float)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Float value) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Double)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Double value) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.math.BigDecimal)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(BigDecimal value) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(String value, Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Integer, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Integer value, Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Float, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Float value, Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.lang.Double, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Double value, Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#listSimple(java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(BigDecimal value, Class<T> clazz) {
		return 공통데이터접근기.list(쿼리아이디생성기.generate(), value, clazz);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.SelectService#one(java.lang.String, T, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return 공통데이터접근기.one(sql, param, clazz);
	}

}
