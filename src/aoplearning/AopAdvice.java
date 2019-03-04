package aoplearning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AopAdvice {

    //@Before("execution(* aoplearning.AopService.*(..))")
    @After("execution(* aoplearning.AopService.*(..))")
    public void adviceMethod(JoinPoint joinPoint) {
        System.out.println();
        System.out.println("我正在执行切面方法");
        System.out.println("我是after的方法");
    }
}
