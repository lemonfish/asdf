
package net.asdf.core.query;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class UriQueryIdGenerator implements QueryIdGenerator {

	/**
	 * 쿼리 아이디가 부여되지 않은 경우 Uri 기반으로 쿼리 아이디를 생성한다.
	 * @return 쿼리 아이디
	 */
	@Override
	public String generate() {
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		builder.removePathExtension();
		String queryId = builder.build().getPath().substring(1).replaceAll("/", ".");
		try {
			queryId = URLDecoder.decode(queryId, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return queryId;
	}
}