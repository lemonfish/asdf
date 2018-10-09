
package net.asdf.core.query;

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

@Component
public class DefaultUpldateQueryExecutor extends AbstractQueryExecutor {

	public int update(String sql) {
		TemplateResult result = createQuery(sql);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}



	public int update(String sql, String param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}
	public int update(String sql, Integer param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}

	public int update(String sql, Long param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}

	public int update(String sql, Float param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}
	public int update(String sql, Double param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}
	public int update(String sql, BigDecimal param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}


	private int updateAndGetInternal(String sql, Object value, Map<String, Object> output) {
		if(!"sqlserver".equals(databaseType)) {
			throw new FrameworkException("키를 지정하지 않은 갱신쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
		}

		TemplateResult tr = createQuery(sql, value);

		Map<String, Object> keys = null;
		keys = this.defaultNamedParameterJdbcTemplate.queryForObject(tr.getSql(), tr.getSqlParameterSource(), getRowMapper());

		if(output != null && keys != null) {
			output.putAll(keys);
		}

		return 1;
	}



	public int updateAndGet(String sql, String value, Map<String, Object> output) {
		return updateAndGetInternal(sql, value, output);
	}

	public int updateAndGet(String sql, Integer value, Map<String, Object> output) {
		return updateAndGetInternal(sql, value, output);
	}

	public int updateAndGet(String sql, Long value, Map<String, Object> output) {
		return updateAndGetInternal(sql, value, output);
	}

	public int updateAndGet(String sql, Float value, Map<String, Object> output) {
		return updateAndGetInternal(sql, value, output);
	}

	public int updateAndGet(String sql, Double value, Map<String, Object> output) {
		return updateAndGetInternal(sql, value, output);
	}

	public int updateAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return updateAndGetInternal(sql, value, output);
	}



	public int update(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}

	public <T extends Model> int update(String sql, T param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource());
	}



	public <T extends Model> int updateAndGet(String sql, T param) {
		TemplateResult result = createQuery(sql, param, true);

		int updatedRowCount = 1;

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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		//BeanWrapper beanWrapper = PropertyAccessorFactory.forDirectFieldAccess(param);
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(param);
		beanWrapper.setPropertyValues(returnMap);

		return updatedRowCount;
	}

	public <T extends Model> int updateAndGet(String sql, T param, Map<String, Object> output) {
		TemplateResult result = createQuery(sql, param, true);

		int updatedRowCount = 1;

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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return updatedRowCount;
	}

	public <T extends Model> int updateAndGet(String sql, T param, String[] outColumns, Map<String, Object> output) {
		TemplateResult result = createQuery(sql, param);

		int updatedRowCount = 1;

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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
			throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return updatedRowCount;
	}

	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns) {
		TemplateResult result = createQuery(sql, param);

		int updatedRowCount = 1;

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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;

			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		param.putAll(returnMap);

		return updatedRowCount;
	}

	public int updateAndGet(String sql, Map<String, Object> param, String[] outColumns, Map<String,Object> output) {
		TemplateResult result = createQuery(sql, param);

		int updatedRowCount = 1;

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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
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
					updatedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
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
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
			break;
			default:
				throw new UnsupportedOperationException("지원하지 않는 유형의 데이터베이스입니다: " + databaseType);
		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return updatedRowCount;
	}



	public int updateAndGet(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);

		int updatedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		if(!"sqlserver".contentEquals(databaseType)) {
			throw new FrameworkException("키를 지정하지 않은 수정쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
		}

		returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());

		param.putAll(returnMap);

		return updatedRowCount;
	}
}
