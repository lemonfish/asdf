

package net.asdf.core.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import net.asdf.core.model.Model;
import net.asdf.core.query.template.TemplateResult;

@Component
public class DefaultSelectQueryExecutor extends AbstractQueryExecutor {

	@Value("#{config['query.fetchsize'] ?: 10}")
	private int defaultFetchSize;

	@Value("#{config['query.maxrows'] ?: 10000}")
	private int defaultMaxRows;


	public Map<String,Object> one(String sql){
		TemplateResult result = createQuery(sql);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);
	}

	public <T extends Model> T one(String sql, Class<T> clazz) {
		TemplateResult result = createQuery(sql);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	private Map<String, Object> oneByPrimitive(String sql, Object value){
		TemplateResult result = createQuery(sql, value);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);
	}

	private <T extends Model> T oneByPrimitive(String sql, Object value, Class<T> clazz){
		TemplateResult result = createQuery(sql, value);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	public Map<String, Object> one(String sql, String value){
		return this.oneByPrimitive(sql, value);
	}

	public Map<String, Object> one(String sql, Integer value){
		return this.oneByPrimitive(sql, value);
	}

	public Map<String, Object> one(String sql, Long value){
		return this.oneByPrimitive(sql, value);
	}

	public Map<String, Object> one(String sql, Float value){
		return this.oneByPrimitive(sql, value);
	}

	public Map<String, Object> one(String sql, Double value){
		return this.oneByPrimitive(sql, value);
	}

	public Map<String, Object> one(String sql, BigDecimal value){
		return this.oneByPrimitive(sql, value);
	}

	public <T extends Model> T one(String sql, String value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	public <T extends Model> T one(String sql, Integer value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	public <T extends Model> T one(String sql, Long value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	public <T extends Model> T one(String sql, Float value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	public <T extends Model> T one(String sql, Double value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz){
		return this.oneByPrimitive(sql, value, clazz);
	}

	public <T extends Model> Map<String, Object> one(String sql, T param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);
	}

	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	public Map<String, Object> one(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.camelCaseMapRowMapper);
	}


	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.queryForObject(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}




	public Map<String, Object> get(String sql){
		List<Map<String, Object>> a = this.list(sql, (Map<String,Object>)null, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}

	public Map<String, Object> get(String sql, Map<String, Object> param){
		List<Map<String, Object>> a = this.list(sql, param, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}


	public <T extends Model> T get(String sql, Map<String, Object> param, Class<T> clazz){
		List<T> a = this.list(sql, param, clazz, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}


	public <T extends Model> Map<String, Object> get(String sql, T param){
		List<Map<String, Object>> a = this.list(sql, param, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}


	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz){
		List<S> a = this.list(sql, param, clazz, 1, 1);
		return a.isEmpty() ? null : a.get(0);
	}



	public List<Map<String, Object>> list(String sql) {
		TemplateResult result = createQuery(sql);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), camelCaseMapRowMapper);
	}

	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		TemplateResult result = createQuery(sql);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), this.getRowMapper(clazz));
	}

	private List<Map<String, Object>> listByPrimitive(String sql, Object value){
		TemplateResult result = createQuery(sql, value);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), camelCaseMapRowMapper);
	}


	public List<Map<String, Object>> list(String sql, String value){
		return listByPrimitive(sql, value);
	}

	public List<Map<String, Object>> list(String sql, Integer value){
		return listByPrimitive(sql, value);
	}

	public List<Map<String, Object>> list(String sql, Long value){
		return listByPrimitive(sql, value);
	}

	public List<Map<String, Object>> list(String sql, Float value){
		return listByPrimitive(sql, value);
	}

	public List<Map<String, Object>> list(String sql, Double value){
		return listByPrimitive(sql, value);
	}

	public List<Map<String, Object>> list(String sql, BigDecimal value){
		return listByPrimitive(sql, value);
	}

	private <T extends Model> List<T> listByPrimitive(String sql, Object value, Class<T> clazz){
		TemplateResult result = createQuery(sql, value);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	public <T extends Model> List<T> list(String sql, String value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	public <T extends Model> List<T> list(String sql, Long value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	public <T extends Model> List<T> list(String sql, Float value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	public <T extends Model> List<T> list(String sql, Double value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}

	public <T extends Model> List<T> list(String sql, BigDecimal value, Class<T> clazz){
		return listByPrimitive(sql, value, clazz);
	}


	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), camelCaseMapRowMapper);
	}

	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), camelCaseMapRowMapper);
	}

	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		TemplateResult result = createQuery(sql, param);
		return this.defaultNamedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	public List<Map<String, Object>> list(String sql, Map<String, Object> param, int fetchSize) {
		return this.list(sql, param, fetchSize, -1);
	}

	public List<Map<String, Object>> list(String sql, Map<String,Object> param, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), camelCaseMapRowMapper);
	}

	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz, int fetchSize) {
		return this.list(sql, param, clazz, fetchSize, -1);
	}

	public <T extends Model> List<T> list(String sql, Map<String,Object> param, Class<T> clazz, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize) {
		return this.list(sql, param, fetchSize, -1);
	}

	public <T extends Model> List<Map<String, Object>> list(String sql, T param, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), camelCaseMapRowMapper);
	}

	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize) {
		return this.list(sql, param, clazz, fetchSize, -1);
	}

	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz, int fetchSize, int maxRows) {
		TemplateResult result = createQuery(sql, param);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		jdbcTemplate.setFetchSize(fetchSize == -1 ? defaultFetchSize : fetchSize);
		jdbcTemplate.setMaxRows(maxRows == -1 ? defaultMaxRows : maxRows);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		return namedParameterJdbcTemplate.query(result.getSql(), result.getSqlParameterSource(), getRowMapper(clazz));
	}

}
