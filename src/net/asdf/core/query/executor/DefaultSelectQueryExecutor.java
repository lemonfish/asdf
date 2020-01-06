

package net.asdf.core.query.executor;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedCaseInsensitiveMap;

import net.asdf.core.data.ResultConsumer;
import net.asdf.core.model.Model;
import net.asdf.core.query.template.TemplateResult;

@Component("공통SELECT쿼리실행기")
public class DefaultSelectQueryExecutor extends AbstractQueryExecutor implements SelectQueryExecutor {

	@Value("#{asdf['query.fetchsize'] ?: 10}")
	private int defaultFetchSize;

	@Value("#{asdf['query.maxrows'] ?: 10000}")
	private int defaultMaxRows;


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String)
	 */
	@Override
	public Map<String,Object> one(String sql){
		TemplateResult result = createQuery(sql);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Class<T> clazz) {
		TemplateResult result = createQuery(sql);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	private Map<String, Object> oneByPrimitive(String sql, Object value){
		TemplateResult result = createQuery(sql, value);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	private <T extends Model> T oneByPrimitive(String sql, Object value, Class<T> clazz){
		TemplateResult result = createQuery(sql, value);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql, String value){
		return this.oneByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> one(String sql, Integer value){
		return this.oneByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Long)
	 */
	@Override
	public Map<String, Object> one(String sql, Long value){
		return this.oneByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Float)
	 */
	@Override
	public Map<String, Object> one(String sql, Float value){
		return this.oneByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Double)
	 */
	@Override
	public Map<String, Object> one(String sql, Double value){
		return this.oneByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> one(String sql, BigDecimal value){
		return this.oneByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, String value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Long value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Float value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Double value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}




	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#get(java.lang.String)
	 */
	@Override
	public Map<String, Object> get(String sql){
		List<Map<String, Object>> a = this.list(sql, (Map<String,Object>)null, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#get(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> get(String sql, Map<String, Object> param){
		List<Map<String, Object>> a = this.list(sql, param, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#get(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz){
		List<T> a = this.list(sql, param, clazz, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#get(java.lang.String, T)
	 */
	@Override
	public <T extends Model> Map<String, Object> get(String sql, T param){
		List<Map<String, Object>> a = this.list(sql, param, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#get(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz){
		List<S> a = this.list(sql, param, clazz, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}



	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql) {
		TemplateResult result = createQuery(sql);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		TemplateResult result = createQuery(sql);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	private List<Map<String, Object>> listByPrimitive(String sql, Object value){
		TemplateResult result = createQuery(sql, value);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, String value){
		return listByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Integer value){
		return listByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Long)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Long value){
		return listByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Float)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Float value){
		return listByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Double)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Double value){
		return listByPrimitive(sql, value);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, BigDecimal value){
		return listByPrimitive(sql, value);
	}

	private <T extends Model> List<T> listByPrimitive(String sql, Object value, Class<T> clazz){
		TemplateResult result = createQuery(sql, value);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, String value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Long, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Long value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Float value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Double value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}


	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, T)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, T, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.util.Map, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return this.list(sql, param, fetchSize, -1);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String,Object> param, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.공통데이터소스);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return this.list(sql, param, clazz, fetchSize, -1);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, java.util.Map, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String,Object> param, Class<T> clazz, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.공통데이터소스);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, T, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize) {
		return this.list(sql, param, fetchSize, -1);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, T, int, int)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.공통데이터소스);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper());
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, T, java.lang.Class, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return this.list(sql, param, clazz, fetchSize, -1);
	}

	/* (non-Javadoc)
	 * @see net.asdf.core.query.SelectQueryExecutor#list(java.lang.String, T, java.lang.Class, int, int)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.공통데이터소스);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	public void stream(String sql, Map<String, Object> param, ResultConsumer<Map<String, Object>> consumer) {
		TemplateResult result = createQuery(sql, param);

		this.공통명명파라미터JDBC템플릿.query(result.getSql(), result.getSqlParameterSource(), new RowCallbackHandler() {
			private int rowNum = 0;

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Map<String, Object> row = mapRow(rs, rowNum++);
				consumer.consume(row);
			}
		});
	}

	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Map<String, Object> mapOfColValues = createColumnMap(columnCount);
		for (int i = 1; i <= columnCount; i++) {
			String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
			Object obj = getColumnValue(rs, i);
			mapOfColValues.put(key, obj);
		}
		return mapOfColValues;
	}

	/**
	 * Create a Map instance to be used as column map.
	 * <p>By default, a linked case-insensitive Map will be created.
	 * @param columnCount the column count, to be used as initial
	 * capacity for the Map
	 * @return the new Map instance
	 * @see org.springframework.util.LinkedCaseInsensitiveMap
	 */
	protected Map<String, Object> createColumnMap(int columnCount) {
		return new LinkedCaseInsensitiveMap<Object>(columnCount);
	}

	/**
	 * Determine the key to use for the given column in the column Map.
	 * @param columnName the column name as returned by the ResultSet
	 * @return the column key to use
	 * @see java.sql.ResultSetMetaData#getColumnName
	 */
	protected String getColumnKey(String columnName) {
		return columnName;
	}

	/**
	 * Retrieve a JDBC object value for the specified column.
	 * <p>The default implementation uses the {@code getObject} method.
	 * Additionally, this implementation includes a "hack" to get around Oracle
	 * returning a non standard object for their TIMESTAMP datatype.
	 * @param rs is the ResultSet holding the data
	 * @param index is the column index
	 * @return the Object returned
	 * @see org.springframework.jdbc.support.JdbcUtils#getResultSetValue
	 */
	protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
		return JdbcUtils.getResultSetValue(rs, index);
	}

}
