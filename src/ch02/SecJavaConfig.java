package ch02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecJavaConfig {

    @Bean
    public BlankDisc blankDisc(){

        List<String> list = new ArrayList<>();
        list.add("demo2");
        list.add("demo22");
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setName("sssssss");
        blankDisc.setNum(22222);
        blankDisc.setList(list);
        return blankDisc;
    }

}
