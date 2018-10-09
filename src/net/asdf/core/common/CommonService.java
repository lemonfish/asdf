package net.asdf.core.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import net.asdf.core.model.Model;
import net.asdf.core.model.StatefullModel;

/**
 * 단순 CRUD 서비스를 제공한다.
 * 쿼리 아이디가 지정되지 않은 경우 요청 컨텍스트에 기반해 자동으로 생성된 쿼리 아이디를 사용하는 메서드를 제공한다.
 * <p>단순한 기능을 신속히 개발하기 위한 클래스로 단순 SELECT, 단일 트랜잭션으로 끝나는 INSERT, UPDATE, DELETE 쿼리가 아닌 경우 별도 서비스 클래스를 구현해야 한다.</p>
 *
 * @author 김민석 lemonfish@gmail.com
 */
public interface CommonService {

	<T extends Model> List<T> listSimple(BigDecimal value, Class<T> clazz);

	<T extends Model> List<T> listSimple(Double value, Class<T> clazz);

	<T extends Model> List<T> listSimple(Float value, Class<T> clazz);

	<T extends Model> List<T> listSimple(Integer value, Class<T> clazz);

	<T extends Model> List<T> listSimple(String value, Class<T> clazz);

	List<Map<String, Object>> listSimple(BigDecimal value);

	List<Map<String, Object>> listSimple(Double value);

	List<Map<String, Object>> listSimple(Float value);

	List<Map<String, Object>> listSimple(Integer value);

	List<Map<String, Object>> listSimple(String value);

	<T extends Model> T one(String sql, BigDecimal value, Class<T> clazz);

	<T extends Model> T one(String sql, Double value, Class<T> clazz);

	<T extends Model> T one(String sql, Float value, Class<T> clazz);

	<T extends Model> T one(String sql, Integer value, Class<T> clazz);

	<T extends Model> T one(String sql, String value, Class<T> clazz);

	Map<String, Object> one(String sql, BigDecimal value);

	Map<String, Object> one(String sql, Double value);

	Map<String, Object> one(String sql, Float value);

	Map<String, Object> one(String sql, Integer value);

	Map<String, Object> one(String sql, String value);

	Map<String, Object> oneSimple(BigDecimal value);

	Map<String, Object> oneSimple(Double value);

	Map<String, Object> oneSimple(Float value);

	Map<String, Object> oneSimple(Integer value);

	Map<String, Object> oneSimple(String value);

	<T extends Model> List<T> list(String sql, Integer value, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Model param, Class<T> clazz);

	<T extends Model> List<T> list(String sql, Map<String, Object> param, Class<T> clazz);

	List<Map<String, Object>> list(String sql, Map<String, Object> param);

	<T extends Model> List<Map<String, Object>> list(String sql, T param);

	List<Map<String, Object>> list(String sql);

	<T extends Model, S extends Model> List<S> listSimple(T param, Class<S> clazz);

	<T extends Model> List<T> listSimple(Map<String, Object> param, Class<T> clazz);

	<T extends Model> List<Map<String, Object>> listSimple(T param);

	List<Map<String, Object>> listSimple(Map<String, Object> param);

	<T extends Model> List<T> listSimple(Class<T> clazz);

	List<Map<String, Object>> listSimple();

	Map<String, Object> oneSimple(Map<String, Object> param);

	<T extends Model> Map<String, Object> oneSimple(T param);

	Map<String, Object> oneSimple();

	<T extends Model> T oneSimple(Class<T> clazz);

	<T extends Model> T oneSimple(Map<String, Object> param, Class<T> clazz);

	<T extends Model> T oneSimple(Model param, Class<T> clazz);

	<T extends Model> T one(String sql, Map<String, Object> param, Class<T> clazz);

	<T extends Model, S extends Model> S one(String sql, T param, Class<S> clazz);

	<T extends Model> Map<String, Object> one(String sql, T param);

	Map<String, Object> one(String sql, Map<String, Object> param);

	<T extends Model> T one(String sql, Class<T> clazz);

	Map<String, Object> one(String sql);

	<T extends Model> List<T> list(String sql, Class<T> clazz);

	<T extends Model> T getSimple(Model param, Class<T> clazz);

	<T extends Model> T getSimple(Map<String, Object> param, Class<T> clazz);

	<T extends Model> Map<String, Object> getSimple(T param);

	Map<String, Object> getSimple(Map<String, Object> param);

	Map<String, Object> getSimple();

	<T extends Model, S extends Model> S get(String sql, T param, Class<S> clazz);

	<T extends Model> Map<String, Object> get(String sql, T param);

	Map<String, Object> get(String sql, Map<String, Object> param);

	Map<String, Object> get(String sql, String param);

	Map<String, Object> get(String sql, Integer param);

	Map<String, Object> get(String sql);

	<T extends Model> int update(String sql, T param);

	int update(String sql, Map<String, Object> param);

	int updateAndGet(String sql, Map<String, Object> param, String[] columns);

	<T extends Model> int updateAndGet(String sql, T param);

	int update(String sql, BigDecimal value);

	int update(String sql, Long value);

	int update(String sql, Integer value);

	int update(String sql, String value);

	int update(String sql);

	int updateSimple(Map<String, Object> param);

	<T extends Model> int updateSimple(T param);

	int updateSimple(String value);

	int updateSimple();

	int insert(String sql, Map<String, Object> param, String[] columns);

	int insert(String sql, Map<String, Object> param);

	<T extends Model> int insertAndGet(String sql, T param);

	int insertAndGet(String sql, Map<String, Object> param, String[] columns);

	<T extends Model> int insert(String sql, T param);

	int insert(String sql, BigDecimal value);

	int insert(String sql, Double value);

	int insert(String sql, Float value);

	int insert(String sql, Long value);

	int insert(String sql, Integer value);

	int insert(String sql, String value);

	int insert(String sql);

	int insertAndGetSimple(Map<String, Object> param, String[] columns);

	<T extends Model> int insertAndGetSimple(T param);

	int insertSimple(BigDecimal value);

	int insertSimple(Double value);

	int insertSimple(Float value);

	int insertSimple(Long value);

	int insertSimple(Integer value);

	int insertSimple(String value);

	<T extends Model> int insertSimple(T param);

	int insertSimple(Map<String, Object> param);

	int insertSimple();

	int[] saveMap(String sqlPrefix, List<Map<String, Object>> 저장할데이터목록);

	<T extends StatefullModel> int[] loopMap(String sql, List<Map<String, Object>> 저장할데이터목록, String dataStatus, String sqlStatus);

	<T extends StatefullModel> int[] saveModel(String sqlPrefix, List<T> 저장할데이터목록, boolean useAndGet);

	<T extends StatefullModel> int[] loopModel(String sql, List<T> 저장할데이터목록, String dataStatus, String sqlStatus, boolean useAndGet);


}