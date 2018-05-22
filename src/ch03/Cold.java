package ch03;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@interface Cold {
}

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@interface Sweet {
}

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@interface Hot {
}
