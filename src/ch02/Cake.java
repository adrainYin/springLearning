package ch02;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * primary注解表示了在Spring容器初始化的时候bean对象的自动装配策略
 * 当有相同类型的bean对象 被创建时候，会根据定义的primary注解选择最高优先级的bean进行装配
 * primary可以定义在Component上表示在扫描组件时候
 * 也可以定义在bean注解上表示在bean创建的时候进行最优的匹配
 */
@Component
//@Primary
public class Cake implements Dessert{
    @Override
    public void make() {
        System.out.println("制作小蛋糕");
    }
}
