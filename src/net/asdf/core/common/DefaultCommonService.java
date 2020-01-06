
package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import net.asdf.core.data.CommonDao;
import net.asdf.core.jdbc.transaction.NeedTx;
import net.asdf.core.jdbc.transaction.NoTx;
import net.asdf.core.model.Model;
import net.asdf.core.model.StatefullModel;
import net.asdf.core.query.QueryIdGenerator;

@Service("공통서비스")
public class DefaultCommonService implements CommonService {

	private Logger logger = LogManager.getLogger(this);

	@Resource
	private CommonDao 공통데이터접근기;

	private boolean 데이터접근기직접설정;

	@Resource
	private QueryIdGenerator 쿼리아이디생성기;

	private boolean 쿼리아이디생성기직접설정;

	/**
	 * 생성 서비스
	 */
	@Resource(name="공통INSERT서비스")
	private InsertService insert;

	/**
	 * 수정, 삭제 서비스
	 */
	@Resource(name="공통UPDATE서비스")
	private UpdateService update;

	/**
	 * 조회 서비스
	 */
	@Resource(name="공통SELECT서비스")
	private SelectService select;

	/**
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple()
	 */
	@Override
	@NeedTx
	public int insertSimple() {
		return insert.insertSimple();
	}

	/**
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.util.Map)
	 */
	@Override
	@NeedTx
	public int insertSimple(Map<String, Object> param) {
		return insert.insertSimple(param);
	}

	/**
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertSimple(T param) {
		return insert.insertSimple(param);
	}

	/**
	 * @param value 문자열 파라미터
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.String)
	 */
	@Override
	@NeedTx
	public int insertSimple(String value) {
		return insert.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Integer)
	 */
	@Override
	@NeedTx
	public int insertSimple(Integer value) {
		return insert.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Long)
	 */
	@Override
	@NeedTx
	public int insertSimple(Long value) {
		return insert.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Float)
	 */
	@Override
	@NeedTx
	public int insertSimple(Float value) {
		return insert.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.lang.Double)
	 */
	@Override
	@NeedTx
	public int insertSimple(Double value) {
		return insert.insertSimple(value);
	}

	/**
	 * @param value
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertSimple(java.math.BigDecimal)
	 */
	@Override
	@NeedTx
	public int insertSimple(BigDecimal value) {
		return insert.insertSimple(value);
	}

	/**
	 * @param param
	 * @return 입력된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insertAndGetSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NeedTx
	public <T extends Model> int insertAndGetSimple(T param) {
		return insert.insertAndGetSimple(param);
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
		return insert.insertAndGetSimple(param, columns);
	}

	/**
	 * @param sql
	 * @return 입려된 행 수
	 * @see net.asdf.core.common.DefaultInsertService#insert(java.lang.String)
	 */
	@Override
	@NeedTx
	public int insert(String sql) {
		return insert.insert(sql);
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
		return insert.insert(sql, value);
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
		return insert.insert(sql, value);
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
		return insert.insert(sql, value);
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
		return insert.insert(sql, value);
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
		return insert.insert(sql, value);
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
		return insert.insert(sql, value);
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
		return insert.insert(sql, param);
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
		return insert.insertAndGet(sql, param);
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
		return insert.insert(sql, param);
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
		return insert.insert(sql, param, columns);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#updateSimple()
	 */
	@Override
	@NeedTx
	public int updateSimple() {
		return update.updateSimple();
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#updateSimple(java.lang.String)
	 */
	@Override
	@NeedTx
	public int updateSimple(String value) {
		return update.updateSimple(value);
	}

	@Override
	@NeedTx
	public int updateSimple(Map<String, Object> param) {
		return update.updateSimple(param);
	}

	@Override
	@NeedTx
	public <T extends Model> int updateSimple(T param) {
		return update.updateSimple(param);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.common.DefaultUpdateService#update(java.lang.String)
	 */
	@Override
	@NeedTx
	public int update(String sql) {
		return update.update(sql);
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
		return update.update(sql, value);
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
		return update.update(sql, value);
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
		return update.update(sql, value);
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
		return update.update(sql, value);
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
		return update.update(sql, param);
	}

	@Override
	@NeedTx
	public int update(String sql, Map<String, Object> param) {
		return update.update(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#get(java.lang.String, net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz) {
		return select.get(sql, param, clazz);
	}

	@NoTx
	public <T extends Model> Map<String, Object> get(String sql, T param) {
		return select.get(sql, param);
	}

	@Override
	@NoTx
	public Map<String, Object> get(String sql, Map<String, Object> param) {
		return select.get(sql, param);
	}

	@Override
	@NoTx
	public Map<String, Object> get(String sql, String value) {
		return select.get(sql, value);
	}

	@Override
	@NoTx
	public Map<String, Object> get(String sql, Integer value) {
		return select.get(sql, value);
	}

	@Override
	@NoTx
	public Map<String, Object> get(String sql) {
		return select.get(sql);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple()
	 */
	@Override
	@NoTx
	public Map<String, Object> getSimple() {
		return select.getSimple();
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> getSimple(Map<String, Object> param) {
		return select.getSimple(param);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> getSimple(T param) {
		return select.getSimple(param);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#getSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T getSimple(Map<String, Object> param, Class<T> clazz) {
		return select.getSimple(param, clazz);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> list(String sql, Class<T> clazz) {
		return select.list(sql, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql) {
		return select.one(sql);
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Class<T> clazz) {
		return select.one(sql, clazz);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Map<String, Object> param) {
		return select.one(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> one(String sql, T param) {
		return select.one(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.one(sql, param, clazz);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T oneSimple(Map<String, Object> param, Class<T> clazz) {
		return select.oneSimple(param, clazz);
	}

	@Override
	@NoTx
	public <T extends Model> T oneSimple(Model param, Class<T> clazz) {
		return select.oneSimple(param, clazz);
	}

	/**
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T oneSimple(Class<T> clazz) {
		return select.oneSimple(clazz);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple()
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple() {
		return select.oneSimple();
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NoTx
	public <T extends Model> Map<String, Object> oneSimple(T param) {
		return select.oneSimple(param);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.util.Map)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Map<String, Object> param) {
		return select.oneSimple(param);
	}

	/**
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple()
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple() {
		return select.listSimple();
	}

	/**
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Class<T> clazz) {
		return select.listSimple(clazz);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.util.Map)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Map<String, Object> param) {
		return select.listSimple(param);
	}

	/**
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(net.asdf.core.model.Model)
	 */
	@Override
	@NoTx
	public <T extends Model> List<Map<String, Object>> listSimple(T param) {
		return select.listSimple(param);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Map<String, Object> param, Class<T> clazz) {
		return select.listSimple(param, clazz);
	}

	/**
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(net.asdf.core.model.Model, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model, S extends Model> List<S> listSimple(T param, Class<S> clazz) {
		return select.listSimple(param, clazz);
	}

	/**
	 * @param sql
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> list(String sql) {
		return select.list(sql);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, net.asdf.core.model.Model)
	 */
	@Override
	@NoTx
	public <T extends Model> List<Map<String, Object>> list(String sql, T param) {
		return select.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, java.util.Map)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> list(String sql, Map<String, Object> param) {
		return select.list(sql, param);
	}

	/**
	 * @param sql
	 * @param param
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#list(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz) {
		return select.list(sql, param, clazz);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(String value) {
		return select.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Integer)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Integer value) {
		return select.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Float)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Float value) {
		return select.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.lang.Double)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(Double value) {
		return select.oneSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#oneSimple(java.math.BigDecimal)
	 */
	@Override
	@NoTx
	public Map<String, Object> oneSimple(BigDecimal value) {
		return select.oneSimple(value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.String)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, String value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Integer)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Integer value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Float)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Float value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Double)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, Double value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.math.BigDecimal)
	 */
	@Override
	@NoTx
	public Map<String, Object> one(String sql, BigDecimal value) {
		return select.one(sql, value);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, String value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Integer, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Integer value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}



	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Float, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Float value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.lang.Double, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, Double value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param sql
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#one(java.lang.String, java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> T one(String sql, BigDecimal value, Class<T> clazz) {
		return select.one(sql, value, clazz);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.String)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(String value) {
		return select.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Integer)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Integer value) {
		return select.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Float)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Float value) {
		return select.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Double)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(Double value) {
		return select.listSimple(value);
	}

	/**
	 * @param value
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.math.BigDecimal)
	 */
	@Override
	@NoTx
	public List<Map<String, Object>> listSimple(BigDecimal value) {
		return select.listSimple(value);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.String, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(String value, Class<T> clazz) {
		return select.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Integer, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Integer value, Class<T> clazz) {
		return select.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Float, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Float value, Class<T> clazz) {
		return select.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.lang.Double, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(Double value, Class<T> clazz) {
		return select.listSimple(value, clazz);
	}

	/**
	 * @param value
	 * @param clazz
	 * @return
	 * @see net.asdf.core.common.DefaultSelectService#listSimple(java.math.BigDecimal, java.lang.Class)
	 */
	@Override
	@NoTx
	public <T extends Model> List<T> listSimple(BigDecimal value, Class<T> clazz) {
		return select.listSimple(value, clazz);
	}

	@Override
	@NoTx
	public <T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz) {
		return select.one(sql, param, clazz);
	}

	/**
	 * 맵을 파라미터로 하는 지정된 쿼리 수행 후 지정된 컬럼을 추출하여 맵에 입력한다
	 * @param sql
	 * @param param
	 * @param columns 입력된 행에 대해 추출할 컬럼 목록
	 * @return 입력된 행 수
	 */
	@Override
	@NoTx
	public int insertAndGet(String sql, Map<String, Object> param, String[] columns) {
		return insert.insertAndGet(sql, param, columns);
	}

	@Override
	@NoTx
	public int updateAndGet(String sql, Map<String, Object> param, String[] columns) {
		return update.updateAndGet(sql, param, columns);
	}

	@Override
	@NoTx
	public <T extends Model> int updateAndGet(String sql, T model) {
		return update.updateAndGet(sql, model);
	}

	@Override
	@NoTx
	public <T extends Model> List<T> list(String sql, Integer value, Class<T> clazz) {
		return select.list(sql, value, clazz);
	}

	@Override
	@NeedTx
	public int[] saveMap(String sqlPrefix, List<Map<String, Object>> 저장할데이터목록) {
		int[] 결과건수 = {0, 0, 0, 0};

		if(저장할데이터목록.size() == 0) {
			return 결과건수;
		}
		for(Map<String, Object> 저장할데이터 : 저장할데이터목록) {
			switch((String)저장할데이터.get(StatefullModel.ROW_STATUS_FIELD)) {
			case StatefullModel.STATUS_INSERT:

				insert.insert(sqlPrefix + ".신규", 저장할데이터);
				결과건수[0]++;
				break;
			case StatefullModel.STATUS_UPDATE:
				update.update(sqlPrefix + ".수정", 저장할데이터);
				결과건수[1]++;
				break;
			case StatefullModel.STATUS_DELETE:
				update.update(sqlPrefix + ".삭제", 저장할데이터);
				결과건수[2]++;
				break;
			default:
				결과건수[3]++;
			}
		}

		return 결과건수;
	}

	@Override
	@NeedTx
	public <T extends StatefullModel> int[]  saveModel(String sqlPrefix, List<T> 저장할데이터목록, boolean useAndGet) {
		int[] 결과건수 = {0, 0, 0};

		if(저장할데이터목록.size() == 0) {
			return 결과건수;
		}

		for(StatefullModel 저장할데이터 : 저장할데이터목록) {
			switch(저장할데이터.getRowStatus()) {
			case StatefullModel.STATUS_INSERT:
				if(useAndGet) {
					insert.insertAndGet(sqlPrefix + ".신규", 저장할데이터);
				}else {
					insert.insert(sqlPrefix + ".신규", 저장할데이터);
				}
				결과건수[0]++;
				break;
			case StatefullModel.STATUS_UPDATE:
				if(useAndGet) {
					update.updateAndGet(sqlPrefix + ".수정", 저장할데이터);
				}else {
					update.update(sqlPrefix + ".수정", 저장할데이터);
				}
				결과건수[1]++;
				break;
			case StatefullModel.STATUS_DELETE:
				update.update(sqlPrefix + ".삭제", 저장할데이터);
				결과건수[2]++;
				break;
			default:
				결과건수[3]++;
			}
		}

		return 결과건수;
	}

	@Override
	public <T extends StatefullModel> int[] loopMap(String sql, List<Map<String, Object>> 저장할데이터목록, String dataStatus, String sqlStatus) {

		int[] 결과건수 = new int[저장할데이터목록.size()];

		Arrays.fill(결과건수, 0);

		if(저장할데이터목록.size() == 0) {
			return 결과건수;
		}
		for(int i = 0; i < 저장할데이터목록.size(); i++){
			Map<String, Object> 저장할데이터 = 저장할데이터목록.get(i);

			if(dataStatus.equals(저장할데이터.get(StatefullModel.ROW_STATUS_FIELD))) {
				switch(sqlStatus) {
				case StatefullModel.STATUS_INSERT:
					결과건수[i] = insert.insert(sql, 저장할데이터);
					break;
				case StatefullModel.STATUS_UPDATE:
					결과건수[i] = update.update(sql, 저장할데이터);
					break;
				case StatefullModel.STATUS_DELETE:
					결과건수[i] = update.update(sql, 저장할데이터);
					break;
				default:
					결과건수[i]++;
				}
			}
		}
		return 결과건수;
	}

	@Override
	public <T extends StatefullModel> int[] loopModel(String sql, List<T> 저장할데이터목록, String dataStatus, String sqlStatus, boolean useAndGet) {
		int[] 결과건수 = new int[저장할데이터목록.size()];

		Arrays.fill(결과건수, 0);

		if(저장할데이터목록.size() == 0) {
			return 결과건수;
		}

		for(int i = 0; i < 저장할데이터목록.size(); i++){
			StatefullModel 저장할데이터 = 저장할데이터목록.get(i);
			if(dataStatus.equals(저장할데이터.getRowStatus())) {
				switch(sqlStatus) {
					case StatefullModel.STATUS_INSERT:
						if(useAndGet) {
							결과건수[i] = insert.insertAndGet(sql, 저장할데이터);
						}else {
							결과건수[i] = insert.insert(sql, 저장할데이터);
						}
						break;
					case StatefullModel.STATUS_UPDATE:
						if(useAndGet) {
							결과건수[i] = update.updateAndGet(sql, 저장할데이터);
						}else {
							결과건수[i] = update.update(sql, 저장할데이터);
						}
						break;
					case StatefullModel.STATUS_DELETE:
						결과건수[i] = update.update(sql, 저장할데이터);
						break;
					default:
						결과건수[i]++;
				}
			}
		}

		return 결과건수;
	}

	public void setInsert(InsertService insert) {
		this.insert = insert;
	}

	public void setUpdate(UpdateService update) {
		this.update = update;
	}

	public void setSelect(SelectService select) {
		this.select = select;
	}

	@Override
	public void setCommonDao(CommonDao commonDao) {
		if(!데이터접근기직접설정) {
			this.공통데이터접근기 = commonDao;
			데이터접근기직접설정 = true;
		}else {
			logger.warn("직접설정된 데이터접근기는 변경할 수 없습니다.");
		}
	}

	@Override
	public void setQueryIdGenerator(QueryIdGenerator queryIdGenerator) {
		if(!쿼리아이디생성기직접설정) {
			this.쿼리아이디생성기 = queryIdGenerator;
			쿼리아이디생성기직접설정 = true;
		}else {
			logger.warn("직접설정된 쿼리아이디생성기는 변경할 수 없습니다.");
		}
	}

	@Override
	public <T extends Model, S extends Model> S getSimple(T param, Class<S> clazz) {
		return select.getSimple(param, clazz);
	}

	@Override
	public <T extends Model, S extends Model> List<S> list(String sql, T param, Class<S> clazz) {
		return select.list(sql, param, clazz);
	}

	@PostConstruct
	private void setup() {
		if(insert != null) {
			insert.setCommonDao(this.공통데이터접근기);
			insert.setQueryIdGenerator(this.쿼리아이디생성기);
		}
		if(update != null) {
			update.setCommonDao(this.공통데이터접근기);
			update.setQueryIdGenerator(this.쿼리아이디생성기);
		}
		if(select != null) {
			select.setCommonDao(this.공통데이터접근기);
			select.setQueryIdGenerator(this.쿼리아이디생성기);
		}
	}


}
