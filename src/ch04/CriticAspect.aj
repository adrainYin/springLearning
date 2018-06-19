package ch04;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.config.AopNamespaceUtils;

@Aspect
public class CriticAspect{

    @Pointcut("execution(* ch04.Performance.play(..))")
    public void performance(){}

    private CriticismEngin criticismEngin;

    public void setCriticismEngin(CriticismEngin criticismEngin) {
        this.criticismEngin = criticismEngin;
    }
    @After("performance()")
    public void criticism(){
        System.out.println(criticismEngin.getCritism());
    }
}
