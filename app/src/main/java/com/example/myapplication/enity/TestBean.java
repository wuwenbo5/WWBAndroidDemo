package com.example.myapplication.enity;

import android.util.Log;

import com.example.myapplication.IView;
import com.example.myapplication.dg.ActivityScope;

import javax.inject.Inject;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/11 9:54
 * description：
 * ******************************
 */
@ActivityScope
public class TestBean {

    @Inject
    public TestBean() {
    }

    IView iView;
    public TestBean(IView iView) {
        this.iView = iView;
    }
    public void println(String msg){
        Log.e("TestBean","----------------message = "+msg);
    }
}
