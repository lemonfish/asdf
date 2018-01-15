
package net.asdf.core.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.asdf.core.web.Auth;
import net.asdf.core.web.NoAuth;
import net.asdf.core.web.SessionVariables;

public class AuthInterceptor implements HandlerInterceptor {

	private static final Logger logger = LogManager.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod hm = (HandlerMethod)handler;
		
		Boolean isClassAuth = null;
		Boolean isMethodAuth = null;
		String klassLevel = null;
		String methodLevel = null;
		Class<?> klazz = hm.getBeanType();
		if(klazz.isAnnotationPresent(Auth.class)) {
			isClassAuth = true;
			Auth auth = klazz.getAnnotation(Auth.class);
			if(!"*".equals(auth.value())) {
				klassLevel = auth.value();
			}
		} else if(klazz.isAnnotationPresent(NoAuth.class)) {
			isClassAuth = false;
		}
		
		Method m = hm.getMethod();
		if(m.isAnnotationPresent(Auth.class)) {
			isMethodAuth = true;
			Auth auth = m.getAnnotation(Auth.class);
			if(!"*".equals(auth.value())) {
				methodLevel = auth.value();
			}			
		}else if(m.isAnnotationPresent(NoAuth.class)) {
			isMethodAuth = false;
		}		
		
		boolean isNeedAuth = false;
		String checkLevel = null;
		
		if(isMethodAuth != null) {
			if(isMethodAuth) {
				isNeedAuth = true;
				checkLevel = methodLevel;
			}
		}else if(isClassAuth != null){
			if(isClassAuth) {
				isNeedAuth = true;
				checkLevel = klassLevel;
			}
		}
		if(isNeedAuth) {
			HttpSession nativeSession = request.getSession();
			String token = request.getParameter("token");
			if(token == null) {
				Map<String,Object> result = new HashMap<>();
				result.put("authStatus", "fail");
				result.put("authMessage", "로그인이 필요합니다.");
				writeResponse(response, result);
				return false;
			}else {
				if(nativeSession == null) {
					Map<String,Object> result = new HashMap<>();
					result.put("authStatus", "fail");
					result.put("authMessage", "세션이 만료되었습니다. 다시 로그인해 주시기 바랍니다.");
					writeResponse(response, result);
					return false;
				}else if(nativeSession.getAttribute("token") == null){
					Map<String,Object> result = new HashMap<>();
					result.put("authStatus", "fail");
					result.put("authMessage", "세션이 만료되었습니다. 다시 로그인해 주시기 바랍니다.");
					writeResponse(response, result);
					return false;
				}else if(!token.equals(nativeSession.getAttribute("token"))) {
					Map<String,Object> result = new HashMap<>();
					result.put("authStatus", "fail");
					result.put("authMessage", "ID/PW가 불일치 합니다. 다시 로그인해 주시기 바랍니다.");
					writeResponse(response, result);
					return false;
				}else {
					@SuppressWarnings("unchecked")
					Map<String,Object> sessionMap = (Map<String, Object>) nativeSession.getAttribute(SessionVariables.SESSION_KEY);
					if(checkLevel != null && !checkLevel.equals(sessionMap.get("lvl"))) {
						nativeSession.invalidate();
						Map<String,Object> result = new HashMap<>();
						result.put("authStatus", "fail_level");
						result.put("authMessage", "서비스 이용 권한이 없습니다.");
						writeResponse(response, result);
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private void writeResponse(HttpServletResponse response, Map<String,Object> result) throws IOException {
		PrintWriter pw = response.getWriter();
		ObjectMapper om = JsonFactory.create();
		pw.write(om.toJson(result));		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
