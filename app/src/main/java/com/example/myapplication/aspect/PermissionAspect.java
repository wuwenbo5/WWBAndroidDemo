package com.example.myapplication.aspect;

import android.Manifest;

import com.example.myapplication.MainActivity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/14 17:08
 * description：
 * ******************************
 */

@Aspect
public class PermissionAspect {

    @Around("execution(@android.aspectjdemo.MPermisson * *(..)) && @annotation(permisson)")//@annotation(permisson)用来表示permisson参数是注解类型
    public void checkPermisson(final ProceedingJoinPoint joinPoint, MPermisson permisson) throws Throwable {
        // 权限
        String permissonStr = permisson.value();
        // 正常需要使用维护的栈顶Activity作为上下文，这里为了演示需要
        MainActivity mainActivity = (MainActivity) joinPoint.getThis();          // 权限申请

        //权限申请工具类
//        Utils.requestPermisson(mainActivity, Manifest.permission.CAMERA).callback(new Callback() {
//            public void onGranted() {
//                try {
//                    // 继续执行原方法
//                    joinPoint.proceed();
//                } catch (Throwable throwable) {
//                    throwable.printStackTrace();
//                }
//            }
//
//            public void onDenied() {
//            }
//        });
    }
}

//1，定义注解

//2，编写 PermissionAspect
//3，使用
//@MPermisson(value = Manifest.permission.CAMERA)
//public void camera() {
//    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(getExternalCacheDir() + "photo.jpg")));
//    startActivity(intent);
//}
