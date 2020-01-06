package net.asdf.core.common;

import java.util.List;
import java.util.Map;

import net.asdf.core.model.StatefullModel;

/**
 * 단순 CRUD 서비스를 제공한다.
 * 쿼리 아이디가 지정되지 않은 경우 요청 컨텍스트에 기반해 자동으로 생성된 쿼리 아이디를 사용하는 메서드를 제공한다.
 * <p>단순한 기능을 신속히 개발하기 위한 클래스로 단순 SELECT, 단일 트랜잭션으로 끝나는 INSERT, UPDATE, DELETE 쿼리가 아닌 경우 별도 서비스 클래스를 구현해야 한다.</p>
 *
 * @author 김민석 lemonfish@gmail.com
 */
public interface CommonService extends InsertService, UpdateService, SelectService {

	int[] saveMap(String sqlPrefix, List<Map<String, Object>> 저장할데이터목록);

	<T extends StatefullModel> int[] loopMap(String sql, List<Map<String, Object>> 저장할데이터목록, String dataStatus, String sqlStatus);

	<T extends StatefullModel> int[] saveModel(String sqlPrefix, List<T> 저장할데이터목록, boolean useAndGet);

	<T extends StatefullModel> int[] loopModel(String sql, List<T> 저장할데이터목록, String dataStatus, String sqlStatus, boolean useAndGet);

}