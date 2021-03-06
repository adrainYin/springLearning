package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //取得注解配置
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("prod");
//        annotationConfigApplicationContext.register(Config.class);
//        annotationConfigApplicationContext.refresh();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        //用class取得bean对象
        UserFunctionService userFunctionService = annotationConfigApplicationContext.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("你好"));

        DemoAnnotationService demoAnnotationService = annotationConfigApplicationContext.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = (DemoMethodService) annotationConfigApplicationContext.getBean("demoMethodService");
        demoAnnotationService.add();
        System.out.println("*************我是一条分割线*************");
        demoMethodService.add();
        System.out.println("*************我是一条分割线*************");
        BeanWayService beanWayService = annotationConfigApplicationContext.getBean(BeanWayService.class);

        //DemoBean demoBean = annotationConfigApplicationContext.getBean(DemoBean.class);
        //System.out.println(demoBean.getContent());
        System.out.println("*********测试发布者模式的demo***********");
        DemoPublisher demoPublisher = (DemoPublisher) annotationConfigApplicationContext.getBean("demoPublisher");
        demoPublisher.publish("今天天气不错的啊");
        System.out.println("**********测试aware的demo**********");
        AwareService awareService = (AwareService) annotationConfigApplicationContext.getBean("awareService");
        awareService.outputResult();
        /**
         * 单例模式的初始化在ApplicationContext创建出来的时候就已经存在bean容器中，
         * 而bean对象的销毁发生在applicationContext的关闭或者对bean对象的直接销毁
         */
        //该方法是将bean对象移除管理
        annotationConfigApplicationContext.removeBeanDefinition("beanWayService");
        annotationConfigApplicationContext.close();

        System.out.println("*******下面的输出是异步调用的输出*********");
        ////////////////////////////////////////////////////////////
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        TaskService taskService = (TaskService) applicationContext.getBean("taskService");
//        for (int i = 0; i < 10; i++) {
//            taskService.executeAsyncTask(i);
//            taskService.executeAsyncTaskPlus(i);
//        }
//        applicationContext.close();
//        ScheduledTaskService scheduledTaskService = (ScheduledTaskService) applicationContext.getBean("scheduledTaskService");
        ListService listService = applicationContext.getBean(ListService.class);
        System.out.println(applicationContext.getEnvironment().getProperty("os.name"));
        System.out.println(listService.showListCmd());


    }
}
