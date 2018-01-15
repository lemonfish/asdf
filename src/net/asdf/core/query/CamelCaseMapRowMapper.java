
package net.asdf.core.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

public class CamelCaseMapRowMapper extends ColumnMapRowMapper {

	private Map<String, String> cache = new HashMap<>(1024);

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, Object> resultMap = super.mapRow(rs, rowNum);
		return resultMap;
	}

	@Override
	protected String getColumnKey(String columnName) {
		String convertedColumnName = cache.get(columnName);
		if(convertedColumnName == null) {
			convertedColumnName = JdbcUtils.convertUnderscoreNameToPropertyName(columnName);
			cache.put(columnName, convertedColumnName);
		}
		return convertedColumnName;
	}

}
