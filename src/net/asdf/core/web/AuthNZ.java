package net.asdf.core.web;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * 인증 및 권한이 필요한 서비스임을 표기한다.
 *
 * 어노테이션 속성 정의 없이 선언하는 경우 인증 여부만을 확인한다.
 * 프레임워크에서 기본 제공하는 세션 속성 비교를 통한 권한 검사(SessionAttributeAuthHandler)는 value 값이 "*" 인 경우 모두 허용으로 간주한다.
 *
 * @author lemonfish
 *
 */
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface AuthNZ {

	@AliasFor("value")
	String[] allow() default "*";

	@AliasFor("allow")
	String[] value() default "*";

	boolean authN() default true;

	String attr() default "사용자권한";

	Class<? extends AuthZHandler>[] handler() default { SessionAttributeAuthZHandler.class };

	Class<? extends AuthZHandler>[] extraHandler() default { };
}
