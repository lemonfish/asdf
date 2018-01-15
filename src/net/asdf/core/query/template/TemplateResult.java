

package net.asdf.core.query.template;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class TemplateResult {
	private SqlParameterSource sqlParameterSource;

	private String sql;

	private String[] generatedKeyColumns = ArrayUtils.EMPTY_STRING_ARRAY;
	private Map<String, String> generatedKeyColumnMap = Collections.emptyMap();

	public boolean hasGenKey() {
		return generatedKeyColumns.length != 0;
	}

	public SqlParameterSource getSqlParameterSource() {
		return sqlParameterSource;

	}

	public void setSqlParameterSource(SqlParameterSource sqlParameterSource) {
		this.sqlParameterSource = sqlParameterSource;
	}


	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String[] getGeneratedKeyColumns() {
		return generatedKeyColumns;
	}

	public void setGeneratedKeyColumnMap(Map<String, String> generatedKeyColumnMap) {
		this.generatedKeyColumnMap = generatedKeyColumnMap;
		this.generatedKeyColumns = new String[this.generatedKeyColumnMap.size()];
		this.generatedKeyColumnMap.keySet().toArray(this.generatedKeyColumns);
	}

	public String getGeneratedKeyPropertyName(String generatedKeyColumnName) {
		return this.generatedKeyColumnMap.get(generatedKeyColumnName);
	}

}

