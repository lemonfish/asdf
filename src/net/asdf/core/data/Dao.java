
package net.asdf.core.data;

import net.asdf.core.query.CommonQueryExecutor;

public interface Dao {

	void setQueryExecutor(CommonQueryExecutor queryExecutor);

	static String PARAM_NO_PAGING = "nopaging";

	/**
	 * 다음 페이지의 시작 번호
	 */
	static String PARAM_PAGING_RNUM = "pagingRnum";

	/**
	 * 한 페이지에 담길 최대 행 수
	 */
	static String PARAM_PAGING_SIZE = "pagingSize";

	/**
	 * 페이징 이전에 행 수를 제한하고자 할 경우 사용되는 파라미터 페이징 원본 쿼리의 행수가 1000건 이지만 해당 값을 100으로
	 * 지정할 경우 페이징 이전에 행수를 100건으로 줄인다. 또한 반환되는 총 행 수도 100건으로 지정된다. 즉, 많은 결과가 있지만
	 * 그 중에 일부 결과에서만 페이징을 사용하고자 할 경우에 사용한다.
	 *
	 */
	static String PARAM_PAGING_LIMIT = "pagingLimit";

}
