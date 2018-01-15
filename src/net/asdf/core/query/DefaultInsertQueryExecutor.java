
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
public class DefaultInsertQueryExecutor extends AbstractQueryExecutor {

	public int insert(String sql) {
		TemplateResult tr = createQuery(sql);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, String value) {
		TemplateResult tr = createQuery(sql, value);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, Integer value) {
		TemplateResult tr = createQuery(sql, value);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, Long value) {
		TemplateResult tr = createQuery(sql, value);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, Float value) {
		TemplateResult tr = createQuery(sql, value);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, Double value) {
		TemplateResult tr = createQuery(sql, value);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, BigDecimal value) {
		TemplateResult tr = createQuery(sql, value);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}


	private int insertAndGetInternal(String sql, Object value, Map<String, Object> output) {
		if(!"sqlserver".equals(databaseType)) {
			throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
		}

		TemplateResult tr = createQuery(sql, value);

		Map<String, Object> keys = null;
		keys = this.defaultNamedParameterJdbcTemplate.queryForObject(tr.getSql(), tr.getSqlParameterSource(), this.camelCaseMapRowMapper);

		if(output != null && keys != null) {
			output.putAll(keys);
		}

		return 1;
	}


	public int insertAndGet(String sql, String value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	public int insertAndGet(String sql, Integer value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	public int insertAndGet(String sql, Long value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	public int insertAndGet(String sql, Float value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	public int insertAndGet(String sql, Double value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	public int insertAndGet(String sql, BigDecimal value, Map<String, Object> output) {
		return insertAndGetInternal(sql, value, output);
	}

	public <T extends Model> int insert(String sql, T param) {
		TemplateResult tr = createQuery(sql, param);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}

	public int insert(String sql, Map<String, Object> param) {
		TemplateResult tr = createQuery(sql, param);
		return defaultNamedParameterJdbcTemplate.update(tr.getSql(), tr.getSqlParameterSource());
	}




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
					insertedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
					returnMap = keyHolder.getKeys();
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "sqlserver":
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);

		}

		//BeanWrapper beanWrapper = PropertyAccessorFactory.forDirectFieldAccess(param);
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(param);
		beanWrapper.setPropertyValues(returnMap);

		return insertedRowCount;
	}

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
					insertedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, result.getGeneratedKeyColumns());
					returnMap = keyHolder.getKeys();
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "sqlserver":
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);

		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return insertedRowCount;
	}

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
				if(result.hasGenKey()) {
					KeyHolder keyHolder = new GeneratedKeyHolder();
					insertedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "sqlserver":
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);

		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return insertedRowCount;
	}

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
					insertedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "sqlserver":
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);

		}

		param.putAll(returnMap);

		return insertedRowCount;
	}

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
					insertedRowCount = this.defaultNamedParameterJdbcTemplate.update(result.getSql(), result.getSqlParameterSource(), keyHolder, outColumns);
					returnMap = keyHolder.getKeys();
				}else {
					throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
				}
			break;

			case "sqlserver":
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);

		}

		if(output != null) {
			output.putAll(returnMap);
		}

		return insertedRowCount;
	}

	public int insertAndGet(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);

		int insertedRowCount = 1;

		Map<String,Object> returnMap = Collections.emptyMap();

		/*
		 * 데이터베이스 제품에 따라 처리가 달라 진다.
		 * Oracle의 경우 JDBC API의 GeneratedKeyHolder를 이용한다.
		 * SQL Server의 경우 INSERT문의 OUTPUT절에서 반환되는 값을 추출한다.
		 */

		if("oracle".equals(databaseType)) {
			throw new FrameworkException("키를 지정하지 않은 입력쿼리의 결과값 반환은 SQL Server에서만 지원합니다.");
		}

		switch(databaseType) {
			case "sqlserver":
				returnMap = this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);
			break;
		}

		if(param != null) {
			param.putAll(returnMap);
		}

		return insertedRowCount;
	}
}
