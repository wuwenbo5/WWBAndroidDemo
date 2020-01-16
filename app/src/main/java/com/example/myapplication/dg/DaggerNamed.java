package com.example.myapplication.dg;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/11 11:05
 * description：
 * ******************************
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DaggerNamed {
    String value() default "";
}
