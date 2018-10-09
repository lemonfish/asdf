package net.asdf.core.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;

import net.asdf.core.web.interceptor.AuthNZInterceptor.AuthZInfo;

public interface AuthZHandler {

	public boolean authZ(AuthZInfo authInfo, HandlerMethod handlerMethod, HttpServletRequest request, HttpServletResponse response, HttpSession nativeSession, Map<String, Object> sessionMap);

}
