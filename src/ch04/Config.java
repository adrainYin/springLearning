package ch04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;


@Configuration
/**
 * 开启AOP代理,对所有@Aspect注解定义的Beansing创建代理
 * 代理会围绕所有的切面的切点匹配bean
 */
@EnableAspectJAutoProxy
@ImportResource("classpath:ch04/ch04-spring-config.xml")
public class Config {
    @Bean
    public Audience audience(){
        return new Audience();
    }

    //@Bean
    public CompactDisc compactDisc(){
        return new CDPlayer();
    }

    /**
     * 被声明的切面也作为一个bean对象注册到bean容器中管理
     * @return 返回bean实例
     */
    //@Bean
    public TrackCount trackCount(){
        return new TrackCount();
    }

    @Bean
    public EncorableIntroduce encorableIntroduce(){
        return new EncorableIntroduce();
    }

    @Bean
    public Performance performance(){
        return new PerformanceImp();
    }
}
