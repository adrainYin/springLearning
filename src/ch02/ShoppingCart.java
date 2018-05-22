package ch02;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value ="",
        proxyMode = ScopedProxyMode.INTERFACES)
public interface ShoppingCart {
    void add();
}
