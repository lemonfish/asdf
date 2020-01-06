package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.Map;

import net.asdf.core.data.CommonDao;
import net.asdf.core.model.Model;
import net.asdf.core.query.QueryIdGenerator;

public interface UpdateService extends DefaultService{

	int updateSimple();

	int updateSimple(String value);

	int updateSimple(Map<String, Object> param);

	<T extends Model> int updateSimple(T param);

	int update(String sql);

	int update(String sql, String value);

	int update(String sql, Integer value);

	int update(String sql, Long value);

	int update(String sql, BigDecimal value);

	int updateAndGet(String sql, Map<String, Object> param, String[] columns);

	<T extends Model> int updateAndGet(String sql, T param);

	<T extends Model> int update(String sql, T param);

	int update(String sql, Map<String, Object> param);

}