package test;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        /**
         * 判断操作系统的名字是否含有windows
         */
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
