package net.asdf.core.query.executor;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import net.asdf.core.query.template.QueryTemplateEngine;

public interface QueryExecutor {

	void setTemplateEngine(QueryTemplateEngine templateEngine);

	void setDatabaseType(String databaseType);

	void setDataSource(DataSource dataSource);

	void setRowMapper(RowMapper<Map<String, Object>> rowMapper);

	void setDefaultNamedParameterJdbcTemplate(NamedParameterJdbcTemplate defaultNamedParameterJdbcTemplate);

}
