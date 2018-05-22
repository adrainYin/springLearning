package ch02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.print.attribute.standard.Media;

/**
 在这里该配置类的作用和config.xml的配置作用差不多，一切关于bean管理的配置都会在其中定义
 使用@Configuration注解作为标示，在实例化ApplicationContext的时候需要读取该class文件
 */
@Configuration //定义为配置类
@ComponentScan //启用组建扫描...我也不知道什么意思。默认扫描的是本包下的。如果要扫描别的包下的可以用basePackages修饰数组
public class CDplayerConfig {

    /**
     * Bean注解的意思是该方法会返回一个实例化的对象，通过该注解告诉Spring将该实例化对象注册成bean对象
     * @return
     */
    @Bean
    @Profile("test")
    public CDplayer getNewSgtPeppers(){
        return new SgtPeppers();
    }

    /**
     * 被@Bean注解的返回实例化对象的方法在调用时会被Spring拦截器拦截，而直接返回Bean对象
     * 这里的CdPlayer实例的传入并不是直接对getNewSgtPeppers进行了调用，调用由Spring容器创建的Bean对象
     * @return
     */
//    @Bean
//    public MediaPlayer subMediaPlayer(){
//        return new SubMediaPlayer(getNewSgtPeppers());
//    }

    /**
     * 该注入的bean和上一个方法的注入对象相同，也就是说Bean对象保持了单例性。
     * 对两个方法的普通java调用会返回两个不同的注入对象
     * @return
     */
//    public MediaPlayer anotherMediaPlayer(){
//        return new SubMediaPlayer(getNewSgtPeppers());
//    }
    /**
     * Spring会从各种配置中寻找到cDplayer的bean对象 包括java配置，xml配置等
     * @param cDplayer
     * @return
     */
    @Bean
    @Profile("test")
             //该注解只能接收的类型是class 。他会计算一个返回值是true或者false
            //如果是true那么会创建，是false就不会创建
    public MediaPlayer newMediaPlayer(CDplayer cDplayer){ //此时的CDplayer的bean的创建放在了另外一个配置文件中,但是这样不算是错误
        return new SubMediaPlayer(cDplayer);
    }

    @Bean
    /**
     * 根据conditional的条件判断是否实例化MagicBean的bean对象，接收的参数是.class文件
     * 该类需要实现Conditon接口的方法，该接口只有一个方法：
     * boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
     * Spring容器根据返回值来判定是否实例化对象
     * ConditionContext是条件上下文，可以得到一些bean和class元素的属性和定义
     * AnnotatedTypeMetdata是注解的元数据，可以得到在bean注解上还有哪些注解元素
     */
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }

    @Bean //在这里对bean的属性定义就是设置id值
    @Qualifier("haha")
    @Cold // 此处就是一个自定义的注解
    public Dessert dessert(){
        return new Cake();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
