
package net.asdf.core.web.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.asdf.core.web.AuthNZ;
import net.asdf.core.web.AuthZHandler;
import net.asdf.core.web.NoAuthNZ;
import net.asdf.core.web.SessionVariables;

public class AuthNZInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LogManager.getLogger(AuthNZInterceptor.class);

	@Autowired
	private ApplicationContext appContext;

	private HashMap<HandlerMethod, AuthZInfo> cache = new HashMap<HandlerMethod, AuthZInfo>(128);

	public static final class AuthZInfo {
		private boolean needAuthZ = false;
		private AuthZHandler[] handlers;
		private boolean needAuthN = false;

		private String attrName;
		private String[] attrValue;

		public AuthZInfo(ApplicationContext appContext, Class<?> klass, Method method) {

			if(extractMethodAuthInfo(appContext, method)) {
				extractClassAuthInfo(appContext, klass);
			}
		}

		private boolean extractMethodAuthInfo(ApplicationContext appContext, Method method) {
			boolean proceedNext = false;
			if(method.isAnnotationPresent(AuthNZ.class)) {
				needAuthZ = true;
				AuthNZ auth = method.getAnnotation(AuthNZ.class);

				addHandlers(appContext, auth.handler(), auth.extraHandler());

				attrName = auth.attr();
				attrValue = auth.allow();
				needAuthN = auth.authN();

				logger.debug("method auth param {} {}", attrName, attrValue);

			}else if(method.isAnnotationPresent(NoAuthNZ.class)) {
				needAuthZ = false;
				logger.debug("method auth disabled");
			}else {
				proceedNext = true;
			}
			return proceedNext;
		}

		private void extractClassAuthInfo(ApplicationContext appContext, Class<?> klass) {

			if(klass.isAnnotationPresent(AuthNZ.class)) {
				needAuthZ = true;
				AuthNZ auth = klass.getAnnotation(AuthNZ.class);

				attrName = auth.attr();
				attrValue = auth.allow();
				needAuthN = auth.authN();

				addHandlers(appContext, auth.handler(), auth.extraHandler());

				logger.debug("class auth param {} {}", attrName, attrValue);
			}else {
				needAuthZ = false;
			}
		}

		@SafeVarargs
		private final void addHandlers(ApplicationContext appContext, Class<? extends AuthZHandler>[] ... handlerClassArrays) {

			int handlerCount = 0;
			for(Class<? extends AuthZHandler>[] handlerClassArray : handlerClassArrays) {
				handlerCount += handlerClassArray.length;
			}
			handlers = new AuthZHandler[handlerCount];

			int handlerIndex = 0;
			for(Class<? extends AuthZHandler>[] handlerClassArray : handlerClassArrays) {
				for(Class<? extends AuthZHandler> klass : handlerClassArray) {
					handlers[handlerIndex++] = appContext.getBean(klass);
				}
			}
		}

		public String getAttrName() {
			return attrName;
		}

		public String[] getAttrValue() {
			return attrValue;
		}

		public AuthZHandler[] getHandlers() {
			return handlers;
		}

		public boolean isNeedAuthZ() {
			return needAuthZ;
		}

		public boolean isNeedAuthN() {
			return needAuthN;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod hm = (HandlerMethod)handler;

		AuthZInfo authInfo = null;
		if(cache.containsKey(hm)) {
			authInfo = cache.get(hm);
		}else {
			authInfo = new AuthZInfo(appContext, hm.getBeanType(), hm.getMethod());
			cache.put(hm, authInfo);
		}


		HttpSession nativeSession = request.getSession(false);
		if(authInfo.needAuthN) {
			if(nativeSession == null) {
				// 인증 정보가 없습니다. 401
				// 로그인이 필요함
				response.setHeader("X-Error-Code", "E00001");
				response.setHeader("X-Error-Message", "로그인이 필요합니다.");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}else if(nativeSession.getAttribute("사용자아이디") == null){
				// 인증 정보가 없습니다. 401
				// 세션이 만료됨
				response.setHeader("X-Error-Code", "E00002");
				response.setHeader("X-Error-Message", "세션이 만료되었습니다.");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
		}

		if(authInfo.needAuthZ) {
			Map<String, Object> sessionMap = null;
			if(nativeSession != null) {
				sessionMap = (Map<String, Object>) nativeSession.getAttribute(SessionVariables.SESSION_KEY);
			}

			/* 권한관리 클래스가 지정된 경우 해당 처리를 수행한다. */
			for(AuthZHandler authHandler : authInfo.getHandlers()) {
				if(!authHandler.authZ(authInfo, hm, request, response, nativeSession, sessionMap)) {
					return false;
				}
			}
		}
		return true;
	}

}
