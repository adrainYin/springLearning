package test;

public class BeanWayService {
    public void init(){
        System.out.println("初始化完成");
    }

    public void destroy(){
        System.out.println("销毁完成");
    }

    public BeanWayService(){
        System.out.println("使用构造函数进行初始化操作");
    }
}
