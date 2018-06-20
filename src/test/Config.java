package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@ComponentScan
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public FunctionService functionService(){
        return new FunctionService();
    }

    @Bean
    public UserFunctionService userFunctionService(FunctionService functionService){
        UserFunctionService userFunctionService = new UserFunctionService();
        userFunctionService.setFunctionService(functionService);
        return userFunctionService;
    }

    @Bean
    public DemoAnnotationService demoAnnotationService(){
        return new DemoAnnotationService();
    }

    @Bean
    public DemoMethodService demoMethodService(){
        return new DemoMethodService();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }

    //定义了在不同的环境下对bean的实例化管理
    @Bean
    @Profile("dev")
    public DemoBean demoBean(){
        return new DemoBean("我是一次过正常的demo");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("我是一个测试的生产环境的demo");
    }


}
