package net.asdf.core.model.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * @author lemonfish@gmail.com
 *
 */
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ServiceMapping {

	String[] value() default {};

}
