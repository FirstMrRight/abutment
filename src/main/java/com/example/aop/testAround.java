package com.example.aop;

import java.lang.annotation.*;

/**
 * @author Liu-PC
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface testAround {
    String value() default "0";
}
