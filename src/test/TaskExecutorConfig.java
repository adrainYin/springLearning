package test;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
//该注解的作用是开启异多线程功能
@EnableAsync
//开启计划任务调度注解
@EnableScheduling
public class TaskExecutorConfig implements AsyncConfigurer {
    /**
     * 该重写方法的作用是定义异步执行器
     * 异步执行器是接口，可以以多种的形式实现，这类用线程池模型来实现异步执行器
     * @return 返回初始化的线程池异步执行器
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    @Bean
    public TaskService taskService(){
        return new TaskService();
    }

    /**
     * 调度bean一旦在容器中注册，那么其中的定时任务就会自动运行
     * @return bean的实例化对象
     */
    //@Bean
    public ScheduledTaskService scheduledTaskService(){
        return new ScheduledTaskService();
    }

    /**
     * Conditional注解必须是实现了Condition接口的类，必须定义在类上。
     * 而且其中matches方法的重写返回的是boolean值
     * @return 返回bean对象
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public WindowsListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public LinuxListService linuxListService(){
        return new LinuxListService();
    }

    @Bean
    @Conditional(MacCondition.class)
    public MacListService macListService(){
        return new MacListService();
    }
}
