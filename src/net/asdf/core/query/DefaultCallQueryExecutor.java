
package net.asdf.core.query;

import java.util.Map;

import org.springframework.stereotype.Component;

import net.asdf.core.query.template.TemplateResult;

@Component
public class DefaultCallQueryExecutor extends AbstractQueryExecutor {

	/**
	 * 내장 프로시저 혹은 함수를 호출한다. OUT 파라미터가 있는 경우 파라미터로 입력된 맵에 반환값이 저장된다.
	 *
	 * @param sql
	 * @param paramMap
	 */
	public <T extends Map<String, ?>> void call(String sql, T paramMap) {
		/* TODO 구현해야 함 */
		TemplateResult result = createQuery(sql, paramMap);

	}
}