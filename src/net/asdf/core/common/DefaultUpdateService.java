

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
public class DefaultUpdateService implements DefaultService {

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

	@NeedTx
	public int updateSimple() {
		return commonDao.update(queryIdGenerator.generate());
	}
	@NeedTx
	public int updateSimple(String value) {
		return commonDao.update(queryIdGenerator.generate(), value);
	}
	@NeedTx
	public int updateSimple(Map<String, Object> param) {
		return commonDao.update(queryIdGenerator.generate(), param);
	}

	@NeedTx
	public <T extends Model> int updateSimple(T param) {
		return commonDao.update(queryIdGenerator.generate(), param);
	}


	@NeedTx
	public int update(String sql) {
		return commonDao.update(sql);
	}

	@NeedTx
	public int update(String sql, String value) {
		return commonDao.update(sql, value);
	}
	@NeedTx
	public int update(String sql, Integer value) {
		return commonDao.update(sql, value);
	}
	@NeedTx
	public int update(String sql, Long value) {
		return commonDao.update(sql, value);
	}
	@NeedTx
	public int update(String sql, BigDecimal value) {
		return commonDao.update(sql, value);
	}
	@NeedTx
	public int updateAndGet(String sql, Map<String, Object> param, String[] columns	) {
		return commonDao.updateAndGet(sql, param, columns);
	}
	@NeedTx
	public <T extends Model> int updateAndGet(String sql, T param) {
		return commonDao.updateAndGet(sql, param);
	}
	@NeedTx
	public <T extends Model> int update(String sql, T param) {
		return commonDao.update(sql, param);
	}
	@NeedTx
	public int update(String sql, Map<String, Object> param) {
		return commonDao.update(sql, param);
	}

}