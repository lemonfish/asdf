
package net.asdf.core.data;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.executor.CommonQueryExecutor;

@Component("공통INSERT데이터접근기")
public class DefaultInsertDao implements InsertDao {

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
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, param, outColumns, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		return 공통쿼리실행기.insertAndGet(sql, param, outColumns);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, param, outColumns, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, param, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param) {
		return 공통쿼리실행기.insertAndGet(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.util.Map)
	 */
	@Override
	public int insert(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.insert(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insert(String sql, T param) {
		return 공통쿼리실행기.insert(sql, param);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return 공통쿼리실행기.insertAndGet(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int insert(String sql, BigDecimal value) {
		return 공통쿼리실행기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	public int insert(String sql, Double value) {
		return 공통쿼리실행기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	public int insert(String sql, Float value) {
		return 공통쿼리실행기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	public int insert(String sql, Long value) {
		return 공통쿼리실행기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int insert(String sql, Integer value) {
		return 공통쿼리실행기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String, java.lang.String)
	 */
	@Override
	public int insert(String sql, String value) {
		return 공통쿼리실행기.insert(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insert(java.lang.String)
	 */
	@Override
	public int insert(String sql) {
		return 공통쿼리실행기.insert(sql);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.data.InsertDao#insertAndGet(java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param) {
		return 공통쿼리실행기.insertAndGet(sql, param);
	}



}