package ch03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@Configuration
@ImportResource("classpath:ch03/ch03-spring-config.xml")
public class Config {


    @Bean
    public SecSimpleJavaClass abstractObject(){
        return new SecSimpleJavaClass();
    }

    @Bean
    public SimpleJavaClass anoabstractObject(){
        return new SimpleJavaClass();
    }


}
