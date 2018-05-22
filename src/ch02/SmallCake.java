package ch02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
/**
 * @Scope注解是作用域注解
 * 设定bean对象的作用域.（1）单例模式(2) 多例模式
 * 使用的是ConfigurableBeanFactory的两个字符串常量:
 * SCOPE_SINGLETON代表单例模式
 * SCOPE_PROTOTYPE代表是多例模式
 * 在bena创建的时候默认是单例模式创建
 * 也可以将该注解定义到Bean注解上
 */
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SmallCake implements Dessert{
    @Override
    public void make() {

    }
}
@Component
/**
 * 这里设置了session作用域的scope设置
 * 第一个参数是web容器的环境上下文，通过Spring容器的WebApplicationContext得到
 * 第二个参数是代理模式,选择是接口代理还是指定类代理
 *
 * 因为在session对象中，一个session生成一个bean，不同的session作用域对于不同的bean。这里
 * 不同于单例模式和多例模式，所以需要代理。
 * 使用代理对象在对象注入的时候注入代理对象，而真正的bean对象可能还没有创建。代理对象会暴露原对象相同的方法，
 * 在真正调用方法的阶段才会对bean懒解析
 */
@Scope(value = "",
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
class ShoppingCar{

}
