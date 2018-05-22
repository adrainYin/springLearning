package ch02;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component //自动扫描注解，会通过扫描确认该类是一个组件，装配成bean对象
public class SgtPeppers implements CDplayer{
    private String title = "001";
    private String artist = "hello";
    @Override
    public void play() {
        System.out.println("play" + title + "by" + artist);
    }


}
