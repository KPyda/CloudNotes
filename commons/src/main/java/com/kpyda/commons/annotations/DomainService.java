package com.kpyda.commons.annotations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * Transactional Domain Service
 */
@Documented
@Service
@Transactional
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainService {
}
