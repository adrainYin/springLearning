package test;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * set方法是自动调用，当实现了接口时，传入的参数就是该bean可以意识到的东西。
 * 当实现了BeanNameAware接口时，set方法的name参数传入的就是当前bean的名字
 * 具体由spring自动实现
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("bean的名称为" + beanName);
        Resource resource = resourceLoader.getResource("test/resource.txt");
        try {
            System.out.println("加载的文件内容为" + IOUtils.toString(resource.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}