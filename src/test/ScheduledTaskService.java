package test;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledTaskService {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    /**
     * 任务的执行不需要显示地调用，当该bean对象注册完成时，带有该注解的方法会自动执行
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("任务每五秒钟执行一次"  + SIMPLE_DATE_FORMAT.format(new Date()));
    }
}
