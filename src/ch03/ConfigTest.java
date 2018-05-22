package ch03;

import static org.junit.Assert.*;

import com.sun.javafx.runtime.SystemProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.SystemPropertyUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class ConfigTest {

//    @Autowired
//    private ComplexJavaClass complexJavaClass;

//    @Autowired
//    private SimpleJavaClass anotherJavaClass;

    /**
     * spring容器的自动转配顺序
     * (1) byType根据class类型进行装配
     * (2) 如果类型在容器汇总不唯一，那么会根据Byname根据bean的ID进行装配
     * (3) 如果ID匹配成功那么装配成功，失败那么会报错
     * (4) 对于接口的自动装配，会自动找到所有子类的实例化bean进行(1)到(3)的装配
     */
    @Autowired
    private AbstractObject aaabstractObject;

    @Test
    public void isAbstractObjectNotNull(){
        assertNotNull(aaabstractObject);
    }

//    @TestAOP
//    public void isSimpleJavaClassNotNull(){
//        assertNotNull(anotherJavaClass);
//    }

//    @TestAOP
//    public void isComplexJavaClassNotNull(){
//        assertNotNull(complexJavaClass);
//    }
}
