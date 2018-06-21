package test;


import org.springframework.scheduling.annotation.Async;

public class TaskService {

    @Async
    public void executeAsyncTask(Integer integer){
        System.out.println("现在执行异步计划" + integer);
    }

    @Async
    public void executeAsyncTaskPlus(Integer integer){
        System.out.println("现在执行的是异步计划加一" + (integer + 1));
    }
}
