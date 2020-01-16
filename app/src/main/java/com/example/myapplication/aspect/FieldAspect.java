package com.example.myapplication.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/14 15:08
 * description：
 * ******************************
 */
@Aspect
public class FieldAspect {
    private static final String TAG = "FieldAspect";

    @Around("get(int com.example.myapplication.enity.Animal.age)")
    public int aroundFieldGet(ProceedingJoinPoint joinPoint) throws Throwable {
        // 执行原代码
        Object obj = joinPoint.proceed();
        int age = Integer.parseInt(obj.toString());
        Log.e(TAG, "age: " + age);
        return 100;
    }
    @Around("set(int com.example.myapplication.enity.Animal.age)&& !withincode(com.example.myapplication.enity.*.new(..))")
    public void aroundFieldSet(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "around-> set age :" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

}
