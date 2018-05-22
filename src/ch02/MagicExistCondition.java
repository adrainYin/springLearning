package ch02;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class MagicExistCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();

        return environment.containsProperty("magic");
    }


}

class ProfileCondition implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (context.getEnvironment() != null){
            MultiValueMap<String, Object> multiValueMap =
                    metadata.getAllAnnotationAttributes(Profile.class.getName());
            if (multiValueMap != null){
                for (Object value : multiValueMap.get("value")){
                    if (context.getEnvironment().acceptsProfiles((String[]) value)){
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}

