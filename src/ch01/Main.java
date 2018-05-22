package ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //ch01.Knight braveKnight = (ch01.Knight)applicationContext.getBean("knight");

        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(Config.class);
        Knight braveKnight = applicationContext.getBean(Knight.class);
        braveKnight.embarkQuest();
        BraveKnight braveKnight1 = acac.getBean(BraveKnight.class);
        braveKnight1.embarkQuest();

        //向下转型为子类， 调用其close()方法因为父类对象没有该方法
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
