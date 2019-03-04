package aoplearning;

import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;

public class Client {


    public static void main(String[] args) {
        AopService aopService = new AopServiceImpl();
        //将需要增强的方法织入工厂
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(aopService);
        aspectJProxyFactory.addAspect(AopAdvice.class);
        aspectJProxyFactory.addAspect(SubAopAdvice.class);
        aspectJProxyFactory.addAspect(SecAopAdvice.class);
        AopService proxyService = aspectJProxyFactory.getProxy();
        proxyService.beforeMethod();
        ThrowsAdviceInterceptor throwsAdviceInterceptor;
        AspectJAroundAdvice aspectJAroundAdvice;
    }
}
