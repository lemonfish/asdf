
package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.executor.CommonQueryExecutor;

@Component("공통UPDATE데이터접근기")
public class DefaultUpdateDao implements Dao, UpdateDao {

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
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, param, outColumns, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return 공통쿼리실행기.updateAndGet(sql, param, outColumns);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, param, outColumns, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, param, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int updateAndGet(String sql, T param) {
		return 공통쿼리실행기.updateAndGet(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int update(String sql, T param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.util.Map)
	 */
	@Override
	public int update(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Double value, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Float value, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Long value, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Integer value, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, String value, Map<String, Object> output) {
		return 공통쿼리실행기.updateAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int update(String sql, BigDecimal param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.lang.Double)
	 */
	@Override
	public int update(String sql, Double param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.lang.Float)
	 */
	@Override
	public int update(String sql, Float param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.lang.Long)
	 */
	@Override
	public int update(String sql, Long param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int update(String sql, Integer param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String, java.lang.String)
	 */
	@Override
	public int update(String sql, String param) {
		return 공통쿼리실행기.update(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#update(java.lang.String)
	 */
	@Override
	public int update(String sql) {
		return 공통쿼리실행기.update(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.UpdateDao#updateAndGet(java.lang.String, java.util.Map)
	 */
	@Override
	public int updateAndGet(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.updateAndGet(sql, param);
	}


}

