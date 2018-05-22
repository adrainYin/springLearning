package ch02;


import org.springframework.context.annotation.*;

/**
 * 当xml和java注解配置同名bean的问题
 * xml中读取bean对象是根据定义的id值
 * 使用bean注解时创建bean对象时是根据方法名
 * 那么会导致xml和bean创建同名bean。因为在Spring容器启动的时候xml会读取两次，
 * spring默认后者创建的bean对象会覆盖前者的bean对象，那么回购xml配置的bean对象会保留
 *
 */
@Configuration
//@ImportResource("classpath:ch02/ch02-spring-config.xml")
@Import({CDplayerConfig.class,JavaConfig.class, ExpressiveConfig.class})
//@Import({JavaConfig.class, SecJavaConfig.class})
public class MainConfig {
}
