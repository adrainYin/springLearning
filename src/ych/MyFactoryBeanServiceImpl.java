package ych;

public class MyFactoryBeanServiceImpl implements MyFactoryBeanService{
    @Override
    public void getBeanName() {
        System.out.println("MyFactoryBeanServiceImpl");
    }

    @Override
    public void produce() {
        System.out.println("我生产了产品");
    }
}
