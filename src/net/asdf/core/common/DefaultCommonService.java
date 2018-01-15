
package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.asdf.core.jdbc.transaction.NeedTx;
import net.asdf.core.model.Model;

@Service
public class DefaultCommonService implements CommonService {

	/**
	 * 생성 서비스
	 */
	@Autowired
	private DefaultInsertService defaultInsertService;

	/**
	 * 수정, 삭제 서비스
	 */
	@Autowired
	private DefaultUpdateService defaultUpdateService;

	/**
	 * 조회 서비스
	 */
	@Autowired
	private DefaultSelectService defaultSelectService;

	/**
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple()
	 */
	@Override
	@NeedTx
	public int insertSimple() {
		return defaultInsertService.insertSimple();
	}

	/**
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.util.Map)
	 */
	@Override
	@NeedTx
	public int insertSimple(Map<String, Object> param) {
		return defaultInsertService.insertSimple(param);
	}

	/**
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertSimple(T param) {
		return defaultInsertService.insertSimple(param);
	}

	/**
	 * @param value 문자열 파라미터
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.String)
	 */
	@Override
	@NeedTx
	public int insertSimple(String value) {
		return defaultInsertService.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int insertSimple(Integer value) {
		return defaultInsertService.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Long)
	 */
	@Override
	@NeedTx
	public int insertSimple(Long value) {
		return defaultInsertService.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Float)
	 */
	@Override
	@NeedTx
	public int insertSimple(Float value) {
		return defaultInsertService.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Double)
	 */
	@Override
	@NeedTx
	public int insertSimple(Double value) {
		return defaultInsertService.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int insertSimple(BigDecimal value) {
		return defaultInsertService.insertSimple(value);
	}

	/**
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertAndGetSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertAndGetSimple(T param) {
		return defaultInsertService.insertAndGetSimple(param);
	}

	/**
	 * @param param
	 * @param columns 입력된 행에 대해 추출할 컬럼 목록
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertAndGetSimple(java.util.Map, java.lang.String[])
	 */
	@Override
	@NeedTx
	public int insertAndGetSimple(Map<String, Object> param, String[] columns) {
		return defaultInsertService.insertAndGetSimple(param, columns);
	}

	/**
	 * @param sql
	 * @return 입려된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String)
	 */
	@Override
	@NeedTx
	public int insert(String sql) {
		return defaultInsertService.insert(sql);
	}

	/**
	 * @param sql
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.lang.String)
	 */
	@Override
	@NeedTx
	public int insert(String sql, String value) {
		return defaultInsertService.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Integer value) {
		return defaultInsertService.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.lang.Long)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Long value) {
		return defaultInsertService.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.lang.Float)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Float value) {
		return defaultInsertService.insert(sql, value);
	}

	/**
	 * @param sql 쿼리 아이디
	 * @param value 배정밀도 파라미터
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.lang.Double)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Double value) {
		return defaultInsertService.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int insert(String sql, BigDecimal value) {
		return defaultInsertService.insert(sql, value);
	}

	/**
	 * @param sql
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insert(String sql, T param) {
		return defaultInsertService.insert(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertAndGet(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertAndGet(String sql, T param) {
		return defaultInsertService.insertAndGet(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.util.Map)
	 */
	@Override
	@NeedTx
	public int insert(String sql, Map<String, Object> param) {
		return defaultInsertService.insert(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param columns 입력된 행에 대해 추출할 컬럼 목록
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String, java.util.Map, java.lang.String[])
	 */
	@Override
	@NeedTx
	public int insert(String sql, Map<String, Object> param, String[] columns) {
		return defaultInsertService.insert(sql, param, columns);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#updateSimple()
	 */
	@Override
	@NeedTx
	public int updateSimple() {
		return defaultUpdateService.updateSimple();
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#updateSimple(java.lang.String)
	 */
	@Override
	@NeedTx
	public int updateSimple(String value) {
		return defaultUpdateService.updateSimple(value);
	}

	@Override
	@NeedTx
	public int updateSimple(Map<String, Object> param) {
		return defaultUpdateService.updateSimple(param);
	}

	@Override
	@NeedTx
	public <T extends Model> int updateSimple(T param) {
		return defaultUpdateService.updateSimple(param);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String)
	 */
	@Override
	@NeedTx
	public int update(String sql) {
		return defaultUpdateService.update(sql);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String, java.lang.String)
	 */
	@Override
	@NeedTx
	public int update(String sql, String value) {
		return defaultUpdateService.update(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int update(String sql, Integer value) {
		return defaultUpdateService.update(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String, java.lang.Long)
	 */
	@Override
	@NeedTx
	public int update(String sql, Long value) {
		return defaultUpdateService.update(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int update(String sql, BigDecimal value) {
		return defaultUpdateService.update(sql, value);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int update(String sql, T param) {
		return defaultUpdateService.update(sql, param);
	}

	@Override
	@NeedTx
	public int update(String sql, Map<String, Object> param) {
		return defaultUpdateService.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#get(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return defaultSelectService.get(sql, param, clazz);
	}

	@Override
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return defaultSelectService.get(sql, param);
	}

	@Override
	public Map<String, Object> get(String sql) {
		return defaultSelectService.get(sql);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple()
	 */
	@Override
	public Map<String, Object> getSimple() {
		return defaultSelectService.getSimple();
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(java.util.Map)
	 */
	@Override
	public Map<String, Object> getSimple(Map<String, Object> param) {
		return defaultSelectService.getSimple(param);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> Map<String, Object> getSimple(T param) {
		return defaultSelectService.getSimple(param);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T getSimple(Map<String, Object> param, Class<T> clazz) {
		return defaultSelectService.getSimple(param, clazz);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> S getSimple(T param, Class<S> clazz) {
		return defaultSelectService.getSimple(param, clazz);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return defaultSelectService.list(sql, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql) {
		return defaultSelectService.one(sql);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return defaultSelectService.one(sql, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return defaultSelectService.one(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return defaultSelectService.one(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return defaultSelectService.one(sql, param, clazz);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> T oneSimple(Map<String, Object> param, Class<T> clazz) {
		return defaultSelectService.oneSimple(param, clazz);
	}

	/**
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Class)
	 */
	@Override
	public <T extends Model> T oneSimple(Class<T> clazz) {
		return defaultSelectService.oneSimple(clazz);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple()
	 */
	@Override
	public Map<String, Object> oneSimple() {
		return defaultSelectService.oneSimple();
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> Map<String, Object> oneSimple(T param) {
		return defaultSelectService.oneSimple(param);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.util.Map)
	 */
	@Override
	public Map<String, Object> oneSimple(Map<String, Object> param) {
		return defaultSelectService.oneSimple(param);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple()
	 */
	@Override
	public List<Map<String, Object>> listSimple() {
		return defaultSelectService.listSimple();
	}

	/**
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(Class<T> clazz) {
		return defaultSelectService.listSimple(clazz);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> listSimple(Map<String, Object> param) {
		return defaultSelectService.listSimple(param);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> listSimple(T param) {
		return defaultSelectService.listSimple(param);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(Map<String, Object> param, Class<T> clazz) {
		return defaultSelectService.listSimple(param, clazz);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> listSimple(T param, Class<S> clazz) {
		return defaultSelectService.listSimple(param, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> list(String sql) {
		return defaultSelectService.list(sql);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return defaultSelectService.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, java.util.Map)
	 */
	@Override
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return defaultSelectService.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return defaultSelectService.list(sql, param, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return defaultSelectService.list(sql, param, clazz);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.String)
	 */
	@Override
	public Map<String, Object> oneSimple(String value) {
		return defaultSelectService.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> oneSimple(Integer value) {
		return defaultSelectService.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Float)
	 */
	@Override
	public Map<String, Object> oneSimple(Float value) {
		return defaultSelectService.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Double)
	 */
	@Override
	public Map<String, Object> oneSimple(Double value) {
		return defaultSelectService.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> oneSimple(BigDecimal value) {
		return defaultSelectService.oneSimple(value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> one(String sql, String value) {
		return defaultSelectService.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> one(String sql, Integer value) {
		return defaultSelectService.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Float)
	 */
	@Override
	public Map<String, Object> one(String sql, Float value) {
		return defaultSelectService.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Double)
	 */
	@Override
	public Map<String, Object> one(String sql, Double value) {
		return defaultSelectService.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public Map<String, Object> one(String sql, BigDecimal value) {
		return defaultSelectService.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return defaultSelectService.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return defaultSelectService.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return defaultSelectService.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return defaultSelectService.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return defaultSelectService.one(sql, value, clazz);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> listSimple(String value) {
		return defaultSelectService.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Integer)
	 */
	@Override
	public List<Map<String, Object>> listSimple(Integer value) {
		return defaultSelectService.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Float)
	 */
	@Override
	public List<Map<String, Object>> listSimple(Float value) {
		return defaultSelectService.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Double)
	 */
	@Override
	public List<Map<String, Object>> listSimple(Double value) {
		return defaultSelectService.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.math.BigDecimal)
	 */
	@Override
	public List<Map<String, Object>> listSimple(BigDecimal value) {
		return defaultSelectService.listSimple(value);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(String value, Class<T> clazz) {
		return defaultSelectService.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Integer, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(Integer value, Class<T> clazz) {
		return defaultSelectService.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Float, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(Float value, Class<T> clazz) {
		return defaultSelectService.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Double, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(Double value, Class<T> clazz) {
		return defaultSelectService.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	public <T extends Model> List<T> listSimple(BigDecimal value, Class<T> clazz) {
		return defaultSelectService.listSimple(value, clazz);
	}

	@Override
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return defaultSelectService.one(sql, param, clazz);
	}

	/**
	 * 맵을 파라미터로 하는 지정된 쿼리 수행 후 지정된 컬럼을 추출하여 맵에 입력한다
	 * @param sql
	 * @param param
	 * @param columns 입력된 행에 대해 추출할 컬럼 목록
	 * @return 입력된 행 수
	 */
	@Override
	public int insertAndGet(String sql, Map<String, Object> param, String[] columns) {
		return defaultInsertService.insertAndGet(sql, param, columns);
	}

	@Override
	public int updateAndGet(String sql, Map<String, Object> param, String[] columns) {
		return defaultUpdateService.updateAndGet(sql, param, columns);
	}

	@Override
	public <T extends Model> int updateAndGet(String sql, T model) {
		return defaultUpdateService.updateAndGet(sql, model);
	}

}
