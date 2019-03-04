package aoplearning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SecAopAdvice {

    @Before("execution(* aoplearning.AopAdvice.*(..))")
    public void send() {
        System.out.println("我是Aspcet的拦截链的上层");
    }
}
