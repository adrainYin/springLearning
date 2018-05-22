package ch03;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Sweet
@Cold
public class SecSimpleJavaClass implements AbstractObject{
    @Override
    public void fun() {

    }
}
