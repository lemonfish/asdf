
package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.asdf.core.data.CommonDao;
import net.asdf.core.jdbc.transaction.NoTx;
import net.asdf.core.model.Model;
import net.asdf.core.query.QueryIdGenerator;

@Component
public class DefaultSelectService implements DefaultService {

	@Resource
	private CommonDao commonDao;

	@Resource
	private QueryIdGenerator queryIdGenerator;

	@Override
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public void setQueryIdGenerator(QueryIdGenerator queryIdGenerator) {
		this.queryIdGenerator = queryIdGenerator;
	}

	@NoTx
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		List<S> list = commonDao.list(sql, param, clazz);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	@NoTx
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		List<Map<String, Object>> list = commonDao.list(sql, param);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	@NoTx
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		List<Map<String, Object>> list = commonDao.list(sql, param);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@NoTx
	public Map<String, Object> get(String sql, String value) {
		List<Map<String, Object>> list = commonDao.list(sql, value);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	@NoTx
	public Map<String, Object> get(String sql, Integer value) {
		List<Map<String, Object>> list = commonDao.list(sql, value);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	@NoTx
	public Map<String, Object> get(String sql) {
		List<Map<String, Object>> list = commonDao.list(sql);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 파라미터가 없는 단일 맵을 반환하는 쿼리를 실행한다.
	 * 결과가 없는 경우 예외(DataAccessException)가 발생한다.
	 * @return 맵
	 */
	@NoTx
	public Map<String,Object> getSimple() {
		return commonDao.get(queryIdGenerator.generate());
	}
	@NoTx
	public Map<String, Object> getSimple(Map<String, Object> param) {
		return commonDao.get(queryIdGenerator.generate(), param);
	}
	@NoTx
	public <T extends Model> Map<String, Object> getSimple(T param) {
		return commonDao.get(queryIdGenerator.generate(), param);
	}
	@NoTx
	public <T extends Model> T getSimple(Map<String, Object> param, Class<T> clazz) {
		return commonDao.get(queryIdGenerator.generate(), param, clazz);
	}

	/**
	 * 모델이랑 모델 상속 클래스 받고 클래스 객체 반환
	 * @param param
	 * @param clazz
	 * @return
	 */
	@NoTx
	public <T extends Model, S extends Model> S getSimple(T param, Class<S> clazz) {
		return this.get(queryIdGenerator.generate(), param, clazz);
	}
	@NoTx
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return commonDao.list(sql, clazz);
	}
	@NoTx
	public Map<String, Object> one(String sql) {
		return commonDao.one(sql);
	}
	@NoTx
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return commonDao.one(sql, clazz);
	}
	@NoTx
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return commonDao.one(sql, param);
	}
	@NoTx
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return commonDao.one(sql, param);
	}
	@NoTx
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return commonDao.one(sql, param, clazz);
	}

	/**
	 * 맵이랑 모델 상속 클래스 받고 클래스 객체 반환
	 * @param param
	 * @param clazz
	 * @return
	 */
	@NoTx
	public <T extends Model> T oneSimple(Map<String, Object> param, Class<T> clazz) {
		return commonDao.one(queryIdGenerator.generate(), param, clazz);
	}

	@NoTx
	public <T extends Model> T oneSimple(Model param, Class<T> clazz) {
		return commonDao.one(queryIdGenerator.generate(), param, clazz);
	}

	@NoTx
	public <T extends Model> T oneSimple(Class<T> clazz) {
		return commonDao.one(queryIdGenerator.generate(), clazz);
	}
	@NoTx
	public Map<String, Object> oneSimple() {
		return commonDao.one(queryIdGenerator.generate());
	}

	/**
	 * 모델 받고 맵 반환
	 * @param param
	 * @return
	 */
	@NoTx
	public <T extends Model> Map<String, Object> oneSimple(T param) {
		return commonDao.one(queryIdGenerator.generate(), param);
	}

	/**
	 * 맵 받고 맵 반환
	 * 결과가 없는 경우 예외(DataAccessException)가 발생한다.
	 * @param param 조회조건
	 * @return 맵
	 */
	@NoTx
	public Map<String, Object> oneSimple(Map<String, Object> param) {
		return commonDao.one(queryIdGenerator.generate(), param);
	}
	@NoTx
	public List<Map<String, Object>> listSimple() {
		return commonDao.list(queryIdGenerator.generate());
	}
	@NoTx
	public <T extends Model> List<T> listSimple(Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), clazz);
	}

	@NoTx
	public List<Map<String, Object>> listSimple(Map<String, Object> param) {
		return commonDao.list(queryIdGenerator.generate(), param);
	}

	@NoTx
	public <T extends Model> List<Map<String, Object>> listSimple(T param) {
		return commonDao.list(queryIdGenerator.generate(), param);
	}

	@NoTx
	public <T extends Model> List<T> listSimple(Map<String, Object> param, Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), param, clazz);
	}

	@NoTx
	public <T extends Model, S extends Model> List<S> listSimple(T param, Class<S> clazz) {
		return commonDao.list(queryIdGenerator.generate(), param, clazz);
	}

	@NoTx
	public List<Map<String, Object>> list(String sql) {
		return commonDao.list(sql);
	}
	@NoTx
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz) {
		return commonDao.list(sql, value, clazz);
	}
	@NoTx
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return commonDao.list(sql, param);
	}

	@NoTx
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return commonDao.list(sql, param);
	}

	@NoTx
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return commonDao.list(sql, param, clazz);
	}
	@NoTx
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return commonDao.list(sql, param, clazz);
	}

	@NoTx
	public Map<String, Object> oneSimple(String value) {
		return commonDao.one(queryIdGenerator.generate(), value);
	}

	@NoTx
	public Map<String, Object> oneSimple(Integer value) {
		return commonDao.one(queryIdGenerator.generate(), value);
	}

	@NoTx
	public Map<String, Object> oneSimple(Float value) {
		return commonDao.one(queryIdGenerator.generate(), value);
	}

	@NoTx
	public Map<String, Object> oneSimple(Double value) {
		return commonDao.one(queryIdGenerator.generate(), value);
	}

	@NoTx
	public Map<String, Object> oneSimple(BigDecimal value) {
		return commonDao.one(queryIdGenerator.generate(), value);
	}

	@NoTx
	public Map<String, Object> one(String sql, String value) {
		return commonDao.one(sql, value);
	}

	@NoTx
	public Map<String, Object> one(String sql, Integer value) {
		return commonDao.one(sql, value);
	}

	@NoTx
	public Map<String, Object> one(String sql, Float value) {
		return commonDao.one(sql, value);
	}

	@NoTx
	public Map<String, Object> one(String sql, Double value) {
		return commonDao.one(sql, value);
	}

	@NoTx
	public Map<String, Object> one(String sql, BigDecimal value) {
		return commonDao.one(sql, value);
	}



	@NoTx
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return commonDao.one(sql, value, clazz);
	}

	@NoTx
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return commonDao.one(sql, value, clazz);
	}

	@NoTx
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return commonDao.one(sql, value, clazz);
	}

	@NoTx
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return commonDao.one(sql, value, clazz);
	}

	@NoTx
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return commonDao.one(sql, value, clazz);
	}

	@NoTx
	public List<Map<String, Object>> listSimple(String value) {
		return commonDao.list(queryIdGenerator.generate(), value);
	}

	@NoTx
	public List<Map<String, Object>> listSimple(Integer value) {
		return commonDao.list(queryIdGenerator.generate(), value);
	}

	@NoTx
	public List<Map<String, Object>> listSimple(Float value) {
		return commonDao.list(queryIdGenerator.generate(), value);
	}

	@NoTx
	public List<Map<String, Object>> listSimple(Double value) {
		return commonDao.list(queryIdGenerator.generate(), value);
	}

	@NoTx
	public List<Map<String, Object>> listSimple(BigDecimal value) {
		return commonDao.list(queryIdGenerator.generate(), value);
	}

	@NoTx
	public <T extends Model> List<T> listSimple(String value, Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), value, clazz);
	}

	@NoTx
	public <T extends Model> List<T> listSimple(Integer value, Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), value, clazz);
	}

	@NoTx
	public <T extends Model> List<T> listSimple(Float value, Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), value, clazz);
	}

	@NoTx
	public <T extends Model> List<T> listSimple(Double value, Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), value, clazz);
	}

	@NoTx
	public <T extends Model> List<T> listSimple(BigDecimal value, Class<T> clazz) {
		return commonDao.list(queryIdGenerator.generate(), value, clazz);
	}
	@NoTx
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return commonDao.one(sql, param, clazz);
	}

}
