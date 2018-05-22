package ch02;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationUtils {
}

/**
 * 因为限定符注解在对同一个class或者method使用的时候只能使用一次，否则java编译器会报错
 * 那么就需要自己定义Qualifier注解，只需要在自定义注解上机上注解@Qualifier
 * 因为在Qualifier注解上有可以继承的注解定义
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Qualifier
@interface Cold{
    String value() default "";
}
