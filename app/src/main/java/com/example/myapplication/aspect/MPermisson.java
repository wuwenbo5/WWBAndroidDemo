package com.example.myapplication.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/14 17:11
 * description：
 * ******************************
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MPermisson {
    String value();
}