package net.asdf.core.model.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * 모델 클래스를 특정 지정된 키로 매핑한다.
 * @author lemonfish@gmail.com
 *
 */
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassMapping {

	String[] value() default {};

}
