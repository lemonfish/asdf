

package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import net.asdf.core.data.CommonDao;
import net.asdf.core.jdbc.transaction.NeedTx;
import net.asdf.core.model.Model;
import net.asdf.core.query.QueryIdGenerator;

@Component("공통UPDATE서비스")
public class DefaultUpdateService implements UpdateService {

	private Logger logger = LogManager.getLogger(this);

	@Resource
	private CommonDao 공통데이터접근기;

	private boolean 데이터접근기직접설정 = false;

	@Resource
	private QueryIdGenerator 쿼리아이디생성기;

	private boolean 쿼리아이디생성기직접설정;

	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#setCommonDao(net.asdf.core.data.CommonDao)
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
	 * @see net.asdf.core.common.UpdateService#updateSimple()
	 */
	@Override
	@NeedTx
	public int updateSimple() {
		return 공통데이터접근기.update(쿼리아이디생성기.generate());
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#updateSimple(java.lang.String)
	 */
	@Override
	@NeedTx
	public int updateSimple(String value) {
		return 공통데이터접근기.update(쿼리아이디생성기.generate(), value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#updateSimple(java.util.Map)
	 */
	@Override
	@NeedTx
	public int updateSimple(Map<String, Object> param) {
		return 공통데이터접근기.update(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#updateSimple(T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int updateSimple(T param) {
		return 공통데이터접근기.update(쿼리아이디생성기.generate(), param);
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String)
	 */
	@Override
	@NeedTx
	public int update(String sql) {
		return 공통데이터접근기.update(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String, java.lang.String)
	 */
	@Override
	@NeedTx
	public int update(String sql, String value) {
		return 공통데이터접근기.update(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int update(String sql, Integer value) {
		return 공통데이터접근기.update(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String, java.lang.Long)
	 */
	@Override
	@NeedTx
	public int update(String sql, Long value) {
		return 공통데이터접근기.update(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int update(String sql, BigDecimal value) {
		return 공통데이터접근기.update(sql, value);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	@NeedTx
	public int updateAndGet(String sql, Map<String, Object> param, String[] columns	) {
		return 공통데이터접근기.updateAndGet(sql, param, columns);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#updateAndGet(java.lang.String, T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int updateAndGet(String sql, T param) {
		return 공통데이터접근기.updateAndGet(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String, T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int update(String sql, T param) {
		return 공통데이터접근기.update(sql, param);
	}
	/* (non-Javadoc)
	 * @see net.asdf.core.common.UpdateService#update(java.lang.String, java.util.Map)
	 */
	@Override
	@NeedTx
	public int update(String sql, Map<String, Object> param) {
		return 공통데이터접근기.update(sql, param);
	}

}