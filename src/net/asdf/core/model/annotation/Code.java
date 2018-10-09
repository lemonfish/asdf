package net.asdf.core.model.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * 모델 클래스에 정의된 코드유형 필드에 설정한다.
 * 해당 필드에서 사용되는 코드를 정의한다.
 * @author lemonfish@gmail.com
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Code {

	@AliasFor("codes")
	String[] value() default {};

	@AliasFor("value")
	String[] codes() default {};
}
