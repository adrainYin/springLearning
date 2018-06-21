package test;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
/**
 * 实现了自定义的注解类型
 * 可以在后续的配置中进行一键管理
 */
public @interface WiselyConfiguration {
    String[] value() default {};
}
