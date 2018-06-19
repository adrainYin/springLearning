package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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

}
