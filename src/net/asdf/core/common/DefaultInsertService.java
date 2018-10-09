
package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.asdf.core.data.CommonDao;
import net.asdf.core.jdbc.transaction.NeedTx;
import net.asdf.core.model.Model;
import net.asdf.core.query.QueryIdGenerator;

@Component
public class DefaultInsertService implements DefaultService {

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

	/**
	 * 파라미터가 없는 기본 쿼리를 실행한다.
	 * 요청주소에 따라 쿼리아이디를 자동 생성한다.
	 * @return 영향받은 행수
	 */
	@NeedTx
	public int insertSimple() {
		return commonDao.insert(queryIdGenerator.generate());
	}

	@NeedTx
	public int insertSimple(Map<String, Object> param) {
		return commonDao.insert(queryIdGenerator.generate(), param);
	}

	@NeedTx
	public <T extends Model> int insertSimple(T param) {
		return commonDao.insert(queryIdGenerator.generate(), param);
	}

	@NeedTx
	public int insertSimple(String value) {
		return commonDao.insert(queryIdGenerator.generate(), value);
	}

	@NeedTx
	public int insertSimple(Integer value) {
		return commonDao.insert(queryIdGenerator.generate(), value);
	}

	@NeedTx
	public int insertSimple(Long value) {
		return commonDao.insert(queryIdGenerator.generate(), value);
	}

	@NeedTx
	public int insertSimple(Float value) {
		return commonDao.insert(queryIdGenerator.generate(), value);
	}

	@NeedTx
	public int insertSimple(Double value) {
		return commonDao.insert(queryIdGenerator.generate(), value);
	}

	@NeedTx
	public int insertSimple(BigDecimal value) {
		return commonDao.insert(queryIdGenerator.generate(), value);
	}

	@NeedTx
	public <T extends Model> int insertAndGetSimple(T param) {
		return commonDao.insertAndGet(queryIdGenerator.generate(), param);
	}

	@NeedTx
	public int insertAndGetSimple(Map<String, Object> param, String[] columns) {
		return commonDao.insertAndGet(queryIdGenerator.generate(), param, columns);
	}

	@NeedTx
	public int insert(String sql) {
		return commonDao.insert(sql);
	}

	@NeedTx
	public int insert(String sql, String value) {
		return commonDao.insert(sql, value);
	}

	@NeedTx
	public int insert(String sql, Integer value) {
		return commonDao.insert(sql, value);
	}

	@NeedTx
	public int insert(String sql, Long value) {
		return commonDao.insert(sql, value);
	}

	@NeedTx
	public int insert(String sql, Float value) {
		return commonDao.insert(sql, value);
	}

	@NeedTx
	public int insert(String sql, Double value) {
		return commonDao.insert(sql, value);
	}

	@NeedTx
	public int insert(String sql, BigDecimal value) {
		return commonDao.insert(sql, value);
	}

	@NeedTx
	public <T extends Model> int insert(String sql, T param) {
		return commonDao.insert(sql, param);
	}

	@NeedTx
	public <T extends Model> int insertAndGet(String sql, T param) {
		return commonDao.insertAndGet(sql, param);
	}

	@NeedTx
	public int insertAndGet(String sql, Map<String, Object> param, String[] columns) {
		return commonDao.insertAndGet(sql, param, columns);
	}

	@NeedTx
	public int insert(String sql, Map<String, Object> param) {
		return commonDao.insert(sql, param);
	}

	@NeedTx
	public int insert(String sql, Map<String, Object> param, String[] columns) {
		return commonDao.insertAndGet(sql, param, columns);
	}

}
