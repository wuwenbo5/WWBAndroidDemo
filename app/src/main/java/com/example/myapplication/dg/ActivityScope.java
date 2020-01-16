package com.example.myapplication.dg;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/11 11:57
 * description：
 * ******************************
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {}
