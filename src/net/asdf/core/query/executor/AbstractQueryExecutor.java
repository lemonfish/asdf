

package net.asdf.core.query.executor;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import net.asdf.core.model.Model;
import net.asdf.core.query.template.QueryTemplateEngine;
import net.asdf.core.query.template.TemplateResult;

public class AbstractQueryExecutor implements QueryExecutor {

	protected Logger logger = LogManager.getLogger(this);

	@Resource
	protected QueryTemplateEngine 공통쿼리템플릿엔진;

	protected boolean 쿼리템플릿엔진직접설정;

	@Resource
	protected DataSource 공통데이터소스;

	protected boolean 데이터소스직접설정;

	protected String databaseType;

	@Resource
	protected NamedParameterJdbcTemplate 공통명명파라미터JDBC템플릿;

	protected boolean 명명파라미터JDBC템플릿직접설정;

	@Resource
	protected RowMapper<Map<String, Object>> 공통행매퍼;


	protected boolean 행매퍼직접설정;

	@Resource
	private ConversionService conversionService;

	@Override
	public void setTemplateEngine(QueryTemplateEngine templateEngine) {
		if(!쿼리템플릿엔진직접설정) {
			this.공통쿼리템플릿엔진 = templateEngine;
			this.쿼리템플릿엔진직접설정 = true;
		}else {
			logger.warn("직접설정된 쿼리템플릿엔진은 변경할 수 없습니다.");
		}
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		if(!데이터소스직접설정) {
			this.공통데이터소스 = dataSource;
			this.데이터소스직접설정 = true;
			detectDatabaseType();
		}else {
			logger.warn("직접설정된 데이터소스는 변경할 수 없습니다.");
		}
	}

	@Override
	public void setDefaultNamedParameterJdbcTemplate(NamedParameterJdbcTemplate defaultNamedParameterJdbcTemplate) {
		if(!명명파라미터JDBC템플릿직접설정) {
			this.공통명명파라미터JDBC템플릿 = defaultNamedParameterJdbcTemplate;
			this.명명파라미터JDBC템플릿직접설정 = true;
		}else {
			logger.warn("직접설정된 명명파라미터JDBC템플릿은 변경할 수 없습니다.");
		}
	}

    /**
     * 템플릿 엔진 통해 실행할 쿼리를 생성한다.
     *
     * @param sql
     *            쿼리 템플릿
     * @return 템플릿 처리 결과
     */
	protected TemplateResult createQuery(String sql) {
		return 공통쿼리템플릿엔진.eval(sql);
	}

    /**
     * 템플릿 엔진을 통해 실행할 쿼리를 생성한다. 입력된 파라미터를 템플릿 내에서 사용할 수 있다.
     *
     * @param sql
     *            쿼리 템플릿
     * @param param
     *            템플릿 내에서 사용할 변수 혹은 변수가 담긴 객체
     * @return 템플릿 처리 결과
     */
	protected TemplateResult createQuery(String sql, Object param) {
		return 공통쿼리템플릿엔진.eval(sql, param);
	}

    /**
     * 템플릿 엔진을 통해 실행할 쿼리를 생성한다. 입력된 파라미터를 템플릿 내에서 사용할 수 있다.
     *
     * @param sql
     * @param param
     * @param getKey
     *            파라미터가 Model 클래스를 상속한 경우 컬럼 값을 추출할지 선택 가능하다. 기본은 추출하지 않는다.
     * @return
     */
	protected TemplateResult createQuery(String sql, Object param, boolean getKey) {
		return 공통쿼리템플릿엔진.eval(sql, param, getKey);
	}

	/* TODO RowMapper를 캐싱해야 하는지 판단하려면 성능에 미치는 영향을 알아야 하는데. 뒤에 짜보자. */
	protected <T extends Model> RowMapper<T> getRowMapper(Class<T> clazz) {
		BeanPropertyRowMapper<T> o = BeanPropertyRowMapper.newInstance(clazz);
		o.setConversionService(conversionService);
		return o;
	}

	public RowMapper<Map<String, Object>> getRowMapper() {
		return 공통행매퍼;
	}

	@Override
	public void setRowMapper(RowMapper<Map<String, Object>> rowMapper) {
		if(!행매퍼직접설정) {
			this.공통행매퍼 = rowMapper;
			this.행매퍼직접설정 = true;
		}else {
			logger.warn("직접설정된 명명파라미터JDBC템플릿은 변경할 수 없습니다.");
		}
	}

	@Override
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	protected void detectDatabaseType() {
		if(this.databaseType == null) {
			try {
				String driverName = this.공통데이터소스.getConnection().getMetaData().getDriverName().toLowerCase();
				if(driverName.contains("mariadb")) {
					this.databaseType = "mariadb";
				}else if(driverName.contains("oracle")) {
					this.databaseType = "oracle";
				}else if(driverName.contains("sql server")) {
					this.databaseType = "sqlserver";
				}else if(driverName.contains("mysql")) {
					this.databaseType = "mysql";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@PostConstruct
	private void setup() {
		detectDatabaseType();
	}
}