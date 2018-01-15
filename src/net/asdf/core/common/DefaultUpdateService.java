

package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.asdf.core.data.CommonDao;
import net.asdf.core.model.Model;
import net.asdf.core.query.QueryIdGenerator;

@Component
public class DefaultUpdateService implements DefaultService {

	@Autowired
	private CommonDao commonDao;

	@Autowired
	private QueryIdGenerator queryIdGenerator;

	@Override
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public void setQueryIdGenerator(QueryIdGenerator queryIdGenerator) {
		this.queryIdGenerator = queryIdGenerator;
	}


	public int updateSimple() {
		return commonDao.update(queryIdGenerator.generate());
	}

	public int updateSimple(String value) {
		return commonDao.update(queryIdGenerator.generate(), value);
	}

	public int updateSimple(Map<String, Object> param) {
		return commonDao.update(queryIdGenerator.generate(), param);
	}


	public <T extends Model> int updateSimple(T param) {
		return commonDao.update(queryIdGenerator.generate(), param);
	}



	public int update(String sql) {
		return commonDao.update(sql);
	}


	public int update(String sql, String value) {
		return commonDao.update(sql, value);
	}

	public int update(String sql, Integer value) {
		return commonDao.update(sql, value);
	}

	public int update(String sql, Long value) {
		return commonDao.update(sql, value);
	}

	public int update(String sql, BigDecimal value) {
		return commonDao.update(sql, value);
	}

	public int updateAndGet(String sql, Map<String, Object> param, String[] columns	) {
		return commonDao.updateAndGet(sql, param, columns);
	}

	public <T extends Model> int updateAndGet(String sql, T param) {
		return commonDao.updateAndGet(sql, param);
	}

	public <T extends Model> int update(String sql, T param) {
		return commonDao.update(sql, param);
	}

	public int update(String sql, Map<String, Object> param) {
		return commonDao.update(sql, param);
	}

}