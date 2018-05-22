package ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试多个configuration的demo
 */
@Configuration
@ComponentScan
//@ImportResource("classpath:ch02/ch02-spring-config.xml")
public class JavaConfig {

//    @Bean
//    public CDplayer newSgtPeppers(){
//        return new SgtPeppers();
//    }
    @Bean
    @Profile("dev")
    public BlankDisc blankDisc(){
        List<String> list = new ArrayList<>();
        list.add("今天天气不错啊");
        list.add("是的啊");

        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setName("shanghai");
        blankDisc.setNum(11110000);
        blankDisc.setList(list);

        return blankDisc;
    }


}
