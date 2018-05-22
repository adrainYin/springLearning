package ch02;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cookie implements Dessert{
    @Override
    public void make() {
        System.out.println("制作小曲奇");
    }
}
