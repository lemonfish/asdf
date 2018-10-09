package net.asdf.core.web;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 인증이 필요없는 서비스 메서드임을 표시한다.
 *
 * 클래스 레벨에 인증이 선언된 경우 인증이 필요 없는 특정 메서드에 선언한다.
 * @author lemonfish
 *
 */
@Retention(RUNTIME)
@Target({ METHOD })
public @interface NoAuthNZ {

}
