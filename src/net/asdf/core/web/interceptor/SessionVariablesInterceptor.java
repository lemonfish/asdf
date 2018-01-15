




package net.asdf.core.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.asdf.core.web.NoSession;
import net.asdf.core.web.Session;
import net.asdf.core.web.SessionVariables;

public class SessionVariablesInterceptor implements HandlerInterceptor {

	private static final Logger logger = LogManager.getLogger(SessionVariablesInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod hm = (HandlerMethod)handler;

		Boolean isClassUseSession = null;
		Boolean isMethodUseSession = null;

		Class<?> klazz = hm.getBeanType();
		if(klazz.isAnnotationPresent(Session.class)) {
			isClassUseSession = true;
		} else if(klazz.isAnnotationPresent(NoSession.class)) {
			isClassUseSession = false;
		}

		Method m = hm.getMethod();
		if(m.isAnnotationPresent(Session.class)) {
			isMethodUseSession = true;
		}else if(m.isAnnotationPresent(NoSession.class)) {
			isMethodUseSession = false;
		}

		boolean isNeedSession = false;

		if(isMethodUseSession != null) {
			if(isMethodUseSession) {
				isNeedSession = true;
			}
		}else if(isClassUseSession != null){
			if(isClassUseSession) {
				isNeedSession = true;
			}
		}
		if(isNeedSession) {
			HttpSession nativeSession = request.getSession();
			if(nativeSession == null) {
				nativeSession = request.getSession(true);
				logger.info("session created : {} {}", request.getRemoteAddr(), nativeSession.getId());
			}else {
				logger.debug("session already exists : {} {} {}", request.getRemoteAddr(), nativeSession.getId(), nativeSession.getMaxInactiveInterval());
			}
			SessionVariables.popuplate(nativeSession);
			request.setAttribute("_USESESSION_", true);
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null) {
			modelAndView.addObject("세션", SessionVariables.getMap());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Boolean isUseSession = (Boolean) request.getAttribute("_USESESSION_");
		if(isUseSession != null && isUseSession) {
			SessionVariables.sync();
			SessionVariables.clear();
		}
	}

}
