package test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * 这个@Aspect注解很重要，这个注解定义了该类作为一个Aspect的切面类
 * 当然也可以当作普通java类来使用
 */
@Aspect
public class LogAspect {

    @Pointcut("@annotation(test.Action)")
    public void pointCut(){
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println(action.name());
    }

    @Before("execution(* test.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法拦截" + method.getName());
    }
}
