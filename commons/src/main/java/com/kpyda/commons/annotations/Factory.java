package com.kpyda.commons.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Annotation for factory components in system.
 */
@Component
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Factory {
}
