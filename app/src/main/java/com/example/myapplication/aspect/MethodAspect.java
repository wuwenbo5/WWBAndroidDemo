package com.example.myapplication.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/14 14:08
 * description：
 * ******************************
 */
//@Aspect
//public class MethodAspect {
//
//    private static final String TAG = "ConstructorAspect";
//
//    @Pointcut("call(* com.example.myapplication.enity.Animal.fly(..))")
//    public void callMethod() {}
//
////    @Before("callMethod()")
//    public void beforeMethodCall(JoinPoint joinPoint) {
//        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
//    }
//
////    @After("callMethod()")
//    public void afterMethodCall(JoinPoint joinPoint) {
//        Log.e(TAG, "after->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
//    }
//
//
//
//    /**
//     * 不能和Before、After一起使用
//     * @param joinPoint
//     * @throws Throwable
//     */
//    @Around("call(* com.example.myapplication.enity.Animal.fly(..))")
//    public void aroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
//        Log.e(TAG, "around->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
//
//        // 执行原代码
//        joinPoint.proceed();
//    }
//
//    /**
//     * execution 用法
//     * @param joinPoint
//     */
//    @Before("execution(* com.example.myapplication.enity.Animal.fly(..))")
//    public void beforeMethodExecution(JoinPoint joinPoint) {
//        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
//    }
//
//    @Before("execution(* com.example.myapplication.enity.Animal.new(..))")
//    public void beforeConstructorExecution(JoinPoint joinPoint) {
//        Log.e(TAG, "Constructor before->" + joinPoint.getThis().toString() + "#" + joinPoint.getSignature().getName());
//    }
//
//    /**
//     * handler
//     * 不支持@After、@Around
//     */
//    @Before("handler(java.lang.ArithmeticException)")
//    public void handler() {
//        Log.e(TAG, "----------handler--------");
//    }
//    @AfterThrowing(pointcut = "call(* *..*(..))", throwing = "throwable")
//    public void anyFuncThrows(Throwable throwable) {
//        Log.e(TAG, "-----hurtThrows: ", throwable);
//    }
//
//
////    @AfterReturning(pointcut = "execution(* com.example.myapplication.enity.Animal.getHeight(..))", returning = "height")//任意参数
////    @AfterReturning(pointcut = "execution(* com.example.myapplication.enity.Animal.getHeight(int))", returning = "height")//int类型参数
//    @AfterReturning(pointcut = "execution(* com.example.myapplication.enity.Animal.getHeight(..))&& args(int)", returning = "height")//&& args(int)
//    public void getHeight(int height) {
//        Log.d(TAG, "---getHeight: ----" + height);
//    }
//
//}
