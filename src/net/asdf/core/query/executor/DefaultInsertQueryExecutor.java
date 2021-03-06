
package net.asdf.core.query.executor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import net.asdf.core.exception.FrameworkException;
import net.asdf.core.model.Model;
import net.asdf.core.query.template.TemplateResult;

@Component("공통INSERT쿼리실행기")
public class DefaultInsertQueryExecutor extends AbstractQueryExecutor implements InsertQueryExecutor {

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String)
	 */
	@Override
	public int insert(String sql) {
		TemplateResult tr = createQuery(sql);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.lang.String)
	 */
	@Override
	public int insert(String sql, String value) {
		TemplateResult tr = createQuery(sql, value);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	public int insert(String sql, Integer value) {
		TemplateResult tr = createQuery(sql, value);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	public int insert(String sql, Long value) {
		TemplateResult tr = createQuery(sql, value);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	public int insert(String sql, Float value) {
		TemplateResult tr = createQuery(sql, value);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	public int insert(String sql, Double value) {
		TemplateResult tr = createQuery(sql, value);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public int insert(String sql, BigDecimal value) {
		TemplateResult tr = createQuery(sql, value);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}


	private int insertAndGetInternal(String sql, Object value, Map<String, Object> output) {
		if(!"sqlserver".equals(databaseType)) {
			throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
		}

		TemplateResult tr = createQuery(sql, value);

		Map<String, Object> keys = null;
		keys = this.공통명명파라미터JDBC템플릿.queryForObject(tr.getSql(), tr.getSqlParameterSource(), getRowMapper());

		if(output != null && keys != null) {
			output.putAll(keys);
		}

		return 1;
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Integer, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Long, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Float, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.lang.Double, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.math.BigDecimal, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insert(String sql, T param) {
		TemplateResult tr = createQuery(sql, param);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insert(java.lang.String, java.util.Map)
	 */
	@Override
	public int insert(String sql, Map<String, Object> param) {
		TemplateResult tr = createQuery(sql, param);
		return 공통명명파라미터JDBC템플릿.update(tr.getSql(), tr.getSqlParameterSource());
	}




	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, T)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param) {
		TemplateResult result = createQuery(sql, param, true);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */
		switch(databaseType) {
			case "oracle":
				if(result.hasGenKey()) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(result.getGeneratedKeyPropertyName(key), returnMap.remove(key));
					}
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;
			case "mysql":
			case "mariadb":
				if(result.hasGenKey() && result.getGeneratedKeyColumns().length == 1) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(result.getGeneratedKeyPropertyName(result.getGeneratedKeyColumns()[0]), returnMap.remove(key));
					}
				}else {
					if(!result.hasGenKey()) {
						throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
					}
					if(result.getGeneratedKeyColumns().length > 1) {
						throw new FrameworkException("MySQL, MariaDB는 단일 키 반환만을 지원합니다.");
					}
				}
			break;

			case "sqlserver":
				returnMap = this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		//BeanWrapper beanWrapper = PropertyAccessorFactory.forDirectFieldAccess(param);
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(param);
		beanWrapper.setPropertyValues(returnMap);

		return insertedRowCount;
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, T, java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, Map<String, Object> output) {
		TemplateResult result = createQuery(sql, param, true);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */
		switch(databaseType) {
			case "oracle":
				if(result.hasGenKey()) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(result.getGeneratedKeyPropertyName(key), returnMap.remove(key));
					}
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "mysql":
			case "mariadb":
				if(result.hasGenKey() && result.getGeneratedKeyColumns().length == 1) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(result.getGeneratedKeyPropertyName(result.getGeneratedKeyColumns()[0]), returnMap.remove(key));
					}
				}else {
					if(!result.hasGenKey()) {
						throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
					}
					if(result.getGeneratedKeyColumns().length > 1) {
						throw new FrameworkException("MySQL, MariaDB는 단일 키 반환만을 지원합니다.");
					}
				}
			break;

			case "sqlserver":
				returnMap = this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return insertedRowCount;
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, T, java.lang.String[], java.util.Map)
	 */
	@Override
	public <T extends Model> int insertAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		TemplateResult result = createQuery(sql, param);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */
		switch(databaseType) {
			case "oracle":
				if(outColumns != null && outColumns.length > 0) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(key, returnMap.remove(key));
					}
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "mysql":
			case "mariadb":
				if(outColumns != null && outColumns.length == 1) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(key, returnMap.remove(key));
					}
				}else {
					if(outColumns == null) {
						throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
					}
					if(outColumns.length > 1) {
						throw new FrameworkException("MySQL, MariaDB는 단일 키 반환만을 지원합니다.");
					}
				}
			break;

			case "sqlserver":
				returnMap = this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return insertedRowCount;
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		TemplateResult result = createQuery(sql, param);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */
		switch(databaseType) {
			case "oracle":
				if(outColumns != null && outColumns.length > 0) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(key, returnMap.remove(key));
					}
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "mysql":
			case "mariadb":
				if(outColumns != null && outColumns.length == 1) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(key, returnMap.remove(key));
					}
				}else {
					if(outColumns == null) {
						throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
					}
					if(outColumns.length > 1) {
						throw new FrameworkException("MySQL, MariaDB는 단일 키 반환만을 지원합니다.");
					}
				}
			break;

			case "sqlserver":
				returnMap = this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
				break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		param.putAll(returnMap);

		return insertedRowCount;
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.util.Map, java.lang.String[], java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String,Object> output) {
		TemplateResult result = createQuery(sql, param);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */
		switch(databaseType) {
			case "oracle":
				if(outColumns != null && outColumns.length > 0) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(key, returnMap.remove(key));
					}
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "mysql":
			case "mariadb":
				if(outColumns != null && outColumns.length == 1) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.공통명명파라미터JDBC템플릿.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
					for(String key : returnMap.keySet()) {
						returnMap.put(key, returnMap.remove(key));
					}
				}else {
					if(outColumns == null) {
						throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
					}
					if(outColumns.length > 1) {
						throw new FrameworkException("MySQL, MariaDB는 단일 키 반환만을 지원합니다.");
					}
				}
			break;

			case "sqlserver":
				returnMap = this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return insertedRowCount;
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.InsertQueryExecutor#insertAndGet(java.lang.String, java.util.Map)
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */

		if(!"sqlserver".equals(databaseType)) {
			throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
		}

		returnMap = this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());

		if(param != null) {
			param.putAll(returnMap);
		}

		return insertedRowCount;
	}
}
