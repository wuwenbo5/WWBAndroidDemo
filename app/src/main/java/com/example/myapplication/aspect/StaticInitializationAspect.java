package com.example.myapplication.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/14 16:26
 * description：
 * ******************************
 */

@Aspect
public class StaticInitializationAspect {
    private static final String TAG = "StaticAspect";

    @Before("staticinitialization(com.example.myapplication.enity.Animal)")
    public void beforeStaticBlock(JoinPoint joinPoint) {
        Log.d(TAG, "beforeStaticBlock: ");
    }

}
