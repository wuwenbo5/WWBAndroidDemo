package com.example.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2019/12/30 14:04
 * description：
 * ******************************
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
