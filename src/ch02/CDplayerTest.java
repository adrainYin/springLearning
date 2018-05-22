package ch02;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 该注解是重点注解，通过被@Configuation注解的class类来读取bean管理的配置文件，而且可以读取多个
 */
@ContextConfiguration(classes = MainConfig.class)
/**
 * 在集成测试上使用的注解
 * 表示在集成测试的时候激活哪个Profile修饰的bean对象创建
 */
@ActiveProfiles({"dev", "test"})
public class CDplayerTest {

    //记录系统日志
//    @Rule
//    public final SystemOutRule log = new SystemOutRule().enableLog();

    /**
     * 在Spring容器中如果注入了两个实现了相同接口的子类对象，那么Spring会报出匹配错误。。。
     * 我也不知道为什么....
     */

    /**
     * 自动装配是指如果对属性定义了自动装配，会自动在Spring容器中寻找类型合适的Bean对象，根据的是TYPE值，然后装配到
     * 如下的属性。所以Bean对象在容器中必须是单例模式的.
     * Bean容器在服务器启动的时候就会自动扫描并且进行Bean对象的初始化
     */
//    @Autowired
//    private CDplayer sgtPeppers;
//
//    @Autowired
//    private MediaPlayer mediaPlayer;
//
//    @Autowired
//    private BlankDisc blankDisc;

//    @Autowired
//    private Dessert dessert;

    /**
     * 在使用自动装配的时候，自动装配的属性名就是对应的属性ID
     */
    @Autowired
    /**
     * Qualifier注解是根据bean的ID值选择适合的装配对象，不能是空值，
     * 因为空值的话一定会报错，我也不知道为什么
     * 根据此值和bean对象的ID值进行匹配。是一种硬耦合的关系。
     * 也可以对@Bean加限定符的修饰:(1) 先检查Qualifier的定义，如果有合适直接匹配(2) 如果没有合适的再根据ID值进行匹配
     *
     */
    @Qualifier("haha")
    private Dessert dessert;

    @Autowired
    private Disc disc;

//    @TestAOP
//    public void isCDNull(){
//
//        assertNotNull(sgtPeppers);
//    }
//
//    @TestAOP
//    public void isMediaPlayerNull(){
//
//        assertNotNull(mediaPlayer);
//    }
//
//    @TestAOP
//    public void isBlankDiscNotNull(){
//        assertNotNull(blankDisc);
//        System.out.println(blankDisc);
//    }

    @Test
    public void isDessertNotNull(){
        assertNotNull(dessert);
    }

    @Test
    public void isDiscNotNull(){
        assertNotNull(disc);
        System.out.println(disc.getTitle());
        System.out.println(disc.getArtist());
    }

//    @TestAOP
//    public void play(){
//        mediaPlayer.fun();
//        assertEquals("play001byhello\n", log.getLog());
//    }
}