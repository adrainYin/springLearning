package ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ch02/ch02-spring-config.xml");
        BlankDisc blankDisc = (BlankDisc)applicationContext.getBean("blankDisc");

        System.out.println(blankDisc);
        List<String> list = blankDisc.getList();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
