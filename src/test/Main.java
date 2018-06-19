package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //取得注解配置
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        //用class取得bean对象
        UserFunctionService userFunctionService = annotationConfigApplicationContext.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("你好"));

        DemoAnnotationService demoAnnotationService = annotationConfigApplicationContext.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = (DemoMethodService) annotationConfigApplicationContext.getBean("demoMethodService");
        demoAnnotationService.add();
        System.out.println("*************我是一条分割线*************");
        demoMethodService.add();
    }
}
