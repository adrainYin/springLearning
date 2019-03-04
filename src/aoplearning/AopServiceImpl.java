package aoplearning;

public class AopServiceImpl implements AopService{
    @Override
    public void beforeMethod() {
        System.out.println("前置的真实服务");
    }

    @Override
    public void afterMethod() {
        System.out.println("后置的真实服务");
    }
}
