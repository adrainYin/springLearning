package ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
/**
 * PropertySource通过读取资源文件的方法对bean的内容进行注入
 * 通过该注解设置资源文件的classpath进行读取
 * 使用Environment获得全局的资源
 */
@PropertySource("classpath:ch02/app.properties")
public class ExpressiveConfig {

    @Autowired
    Environment environment;

}
