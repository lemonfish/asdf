




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

		boolean useSession = false;
		boolean createSession = false;

		Class<?> klazz = hm.getBeanType();
		if(klazz.isAnnotationPresent(Session.class)) {
			createSession = klazz.getAnnotation(Session.class).value();
			useSession = true;
		}

		Method m = hm.getMethod();
		if(m.isAnnotationPresent(Session.class)) {
			useSession = true;
			createSession = m.getAnnotation(Session.class).value();
		}else if(m.isAnnotationPresent(NoSession.class)) {
			useSession = false;
		}

		if(useSession) {
			HttpSession nativeSession = request.getSession(false);
			if(nativeSession == null) {

				if(createSession) {
					nativeSession = request.getSession();
					logger.debug("@Session 세션이 없어서 생성함 : {} {}", request.getRemoteAddr(), nativeSession.getId());
				}else {
					logger.debug("@Session 세션이 없지만 생성안함");
				}

			}else {
				logger.debug("@Session 기존 세션 반환 : {} {} {}", request.getRemoteAddr(), nativeSession.getId(), nativeSession.getMaxInactiveInterval());
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
