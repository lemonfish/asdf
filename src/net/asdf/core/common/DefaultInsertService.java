
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

@Component("공통INSERT서비스")
public class DefaultInsertService implements InsertService {

	private Logger logger = LogManager.getLogger(this);

	@Resource
	private CommonDao 공통데이터접근기;

	private boolean 데이터접근기직접설정;

	@Resource
	private QueryIdGenerator 쿼리아이디생성기;

	private boolean 쿼리아이디생성기직접설정;


	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#setCommonDao(net.asdf.core.data.CommonDao)
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
	 * @see net.asdf.core.common.InsertService#setQueryIdGenerator(net.asdf.core.query.QueryIdGenerator)
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
	 * @see net.asdf.core.common.InsertService#insertSimple()
	 */
	@Override
	@NeedTx
	public int insertSimple() {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.util.Map)
	 */
	@Override
	@NeedTx
	public int insertSimple(Map<String, Object> param) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertSimple(T param) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.lang.String)
	 */
	@Override
	@NeedTx
	public int insertSimple(String value) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int insertSimple(Integer value) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.lang.Long)
	 */
	@Override
	@NeedTx
	public int insertSimple(Long value) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.lang.Float)
	 */
	@Override
	@NeedTx
	public int insertSimple(Float value) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.lang.Double)
	 */
	@Override
	@NeedTx
	public int insertSimple(Double value) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertSimple(java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int insertSimple(BigDecimal value) {
		return 공통데이터접근기.insert(쿼리아이디생성기.generate(), value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertAndGetSimple(T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertAndGetSimple(T param) {
		return 공통데이터접근기.insertAndGet(쿼리아이디생성기.generate(), param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertAndGetSimple(java.util.Map, java.lang.String[])
	 */
	@Override
	@NeedTx
	public int insertAndGetSimple(Map<String, Object> param, String[] columns) {
		return 공통데이터접근기.insertAndGet(쿼리아이디생성기.generate(), param, columns);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String)
	 */
	@Override
	@NeedTx
	public int insert(String sql) {
		return 공통데이터접근기.insert(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.lang.String)
	 */
	@Override
	@NeedTx
	public int insert(String sql, String value) {
		return 공통데이터접근기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Integer value) {
		return 공통데이터접근기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Long value) {
		return 공통데이터접근기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Float value) {
		return 공통데이터접근기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Double value) {
		return 공통데이터접근기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int insert(String sql, BigDecimal value) {
		return 공통데이터접근기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insert(String sql, T param) {
		return 공통데이터접근기.insert(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertAndGet(java.lang.String, T)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertAndGet(String sql, T param) {
		return 공통데이터접근기.insertAndGet(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	@NeedTx
	public int insertAndGet(String sql, Map<String, Object> param, String[] columns) {
		return 공통데이터접근기.insertAndGet(sql, param, columns);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.util.Map)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Map<String, Object> param) {
		return 공통데이터접근기.insert(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.common.InsertService#insert(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	@NeedTx
	public int insert(String sql, Map<String, Object> param, String[] columns) {
		return 공통데이터접근기.insertAndGet(sql, param, columns);
	}

}
