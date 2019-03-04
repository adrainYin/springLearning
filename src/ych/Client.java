package ych;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;


public class Client {


    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        MyFactoryBeanService service = (MyFactoryBeanService) application.getBean("myFactoryBeanService");
        service.getBeanName();
        service.produce();
    }
}
