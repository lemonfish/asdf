package net.asdf.core.query;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import net.asdf.core.query.template.QueryTemplateEngine;

public interface QueryExecutor {

	void setTemplateEngine(QueryTemplateEngine templateEngine);

	void setDataSource(DataSource dataSource);

	void setDefaultNamedParameterJdbcTemplate(NamedParameterJdbcTemplate defaultNamedParameterJdbcTemplate);

}
