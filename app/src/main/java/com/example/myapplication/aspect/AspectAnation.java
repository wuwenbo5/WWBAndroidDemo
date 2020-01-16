package com.example.myapplication.aspect;

import android.util.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2019/12/30 14:11
 * description：
 * ******************************
 */
@Aspect
public class AspectAnation {
    private static final String TAG = AspectAnation.class.getSimpleName();

    // 定义切点，选择OrderManger类中返回值为任何类型，参数为任何类型的所有方法
    private static final String METHOD_POINTCUT
            = "execution(* com.example.myapplication.*Activity.onCreate(..))";

    @Around(METHOD_POINTCUT)
    public Object longiVerify(ProceedingJoinPoint joinPoint) throws Throwable {
        final Object[] args = joinPoint.getArgs();

        Log.e(TAG,"--------------joinPoint.getArgs  = ");


        return joinPoint.proceed(args);

    }
}
