package net.asdf.core.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import net.asdf.core.web.interceptor.AuthNZInterceptor.AuthZInfo;

@Component
public class SessionAttributeAuthZHandler implements AuthZHandler{

	@Override
	public boolean authZ(AuthZInfo authZInfo, HandlerMethod handlerMethod, HttpServletRequest request, HttpServletResponse response,
			HttpSession nativeSession, Map<String, Object> sessionMap) {
		/* 프레임워크 기본 권한 관리는 세션의 특정 속성 값을 어노테이션에 지정된 값과 비교하는 방식 */
		if(authZInfo.getAttrName() == null) {
			return true;
		}

		String[] values = authZInfo.getAttrValue();
		if(values.length == 1 && values[0].equals("*")) {
			return true;
		}

		if(sessionMap != null && !sessionMap.isEmpty()) {
			String sessionValue = (String) sessionMap.get(authZInfo.getAttrName());
			for(String value : values) {
				if(value.equals(sessionValue)) {
					return true;
				}
			}
		}

		nativeSession.invalidate();
		// 서비스 이용 권한이 없습니다. 403
		response.setHeader("X-Error-Code", "E00003");
		response.setHeader("X-Error-Message", "서비스 이용 권한이 없습니다.");
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return false;
	}

}
