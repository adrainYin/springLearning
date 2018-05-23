package ch04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 定义切面，在使用时候还是需要当作简单bean处理，对其进行实例化
 */
@Aspect
public class EncorableIntroduce {

    /**
     * 该定义还是一个切面
     * 为代理接口引入新的方法。通过引入一个新的接口和其实现类
     * value 定义了被代理对象接口，就是对哪个接口的方法进行扩展，引入新功能(加号表示所有类型的子类型)
     * defaultImpl 定义了新增加的方法的具体实现类，应该是要具体实现了某个接口
     * 注解定义在了一个扩展功能接口的实例化上，表明要引入了的接口
     */
    @DeclareParents(value = "ch04.Performance+", defaultImpl = EncorableImp.class)
    public static Encorable encorable;

    @Before("bean(performance) && this(encorable)")
    public void beforePerformance(Encorable encorable){
        encorable.performanceEncore();
    }
}
