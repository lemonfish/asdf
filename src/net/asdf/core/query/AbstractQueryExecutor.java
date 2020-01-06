

package net.asdf.core.query;

import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import net.asdf.core.model.Model;
import net.asdf.core.query.template.QueryTemplateEngine;
import net.asdf.core.query.template.TemplateResult;

public class AbstractQueryExecutor implements QueryExecutor, InitializingBean {

	@Resource
	protected QueryTemplateEngine templateEngine;

	@Resource
	protected DataSource dataSource;

	@Value("#{asdf['query.databasetype'] ?: 'oracle'}")
	protected String databaseType;

	@Resource(name="defaultNamedParameterJdbcTemplate")
	protected NamedParameterJdbcTemplate defaultNamedParameterJdbcTemplate;


	@Autowired(required=false)
	@Qualifier("defaultRowMapper")
	private RowMapper<Map<String, Object>> rowMapper;

	@Resource
	private ConversionService conversionService;

	@Override
	public void setTemplateEngine(QueryTemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void setDefaultNamedParameterJdbcTemplate(NamedParameterJdbcTemplate defaultNamedParameterJdbcTemplate) {
		this.defaultNamedParameterJdbcTemplate = defaultNamedParameterJdbcTemplate;
	}

    /**
     * 템플릿 엔진 통해 실행할 쿼리를 생성한다.
     *
     * @param sql
     *            쿼리 템플릿
     * @return 템플릿 처리 결과
     */
	protected TemplateResult createQuery(String sql) {
		return templateEngine.eval(sql);
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
		return templateEngine.eval(sql, param);
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
		return templateEngine.eval(sql, param, getKey);
	}

	/* TODO RowMapper를 캐싱해야 하는지 판단하려면 성능에 미치는 영향을 알아야 하는데. 뒤에 짜보자. */
	protected <T extends Model> RowMapper<T> getRowMapper(Class<T> clazz) {
		BeanPropertyRowMapper<T> o = BeanPropertyRowMapper.newInstance(clazz);
		o.setConversionService(conversionService);
		return o;
	}

	public RowMapper<Map<String, Object>> getRowMapper() {
		return rowMapper;
	}

	public void setRowMapper(RowMapper<Map<String, Object>> rowMapper) {
		this.rowMapper = rowMapper;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(this.rowMapper == null) {
			 this.rowMapper = new ColumnMapRowMapper();
		}
	}

}