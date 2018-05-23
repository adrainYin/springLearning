package ch04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 该注解说明此java类是一个切面，其中定义了切点和通知
 */
//@Aspect
public class Audience {

    /**
     * 定义切点，切点定义在该接口的方法之下，定义的方法不重要
     * 该方法主要是给切点定义提供注解依附
     * 也为后面的切面逻辑提供执行标识
     */
    //@Pointcut("execution(* ch04.Performance.play(..))")
    //within限定匹配的包的范围,比如现在5个类有fun方法，我只想匹配其中的四个类的fun方法，这时候就可以
    //用within限定匹配的范围。虽然可以在execution方法中直接定义package.class.fun但是很麻烦
    public void performance(){}

    //@Before("performance()")
    public void takeSeats(){
        System.out.println("观众找到自己的位置");
    }

    //@AfterReturning("performance()")
    public void applause(){
        System.out.println("鼓掌！！！");
    }


    //@AfterThrowing("performance()")
    public void performanceFail(){
        System.out.println("表演失败");
    }

    /**
     * 定义一个环绕通知，将这个方法调用的所有细节都定义了进去
     * 类似于InvocationHandler中的invoke()方法，对代理对象的方法进行扩展
     * @param proceedingJoinPoint 连接点对象进程，调用被通知的方法(就是代理对象中正常需要调用的方法)
     */
    //@Around("performance()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("做好座位");
        System.out.println("演出开始");
        try {
            //该对象的主要方法就是执行连接点原先的操作
            //将控制权交给被通知的方法
            proceedingJoinPoint.proceed();
            System.out.println("鼓掌");
        } catch (Throwable throwable) {
            System.out.println("出现了错误");
            throwable.printStackTrace();
        }

    }
}
