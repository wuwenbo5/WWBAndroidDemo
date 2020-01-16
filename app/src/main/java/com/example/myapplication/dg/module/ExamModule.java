package com.example.myapplication.dg.module;

import android.app.Dialog;
import android.content.Context;

import com.example.myapplication.IView;
import com.example.myapplication.dg.ActivityScope;
import com.example.myapplication.dg.DaggerNamed;
import com.example.myapplication.enity.TestBean;

import dagger.Module;
import dagger.Provides;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/11 9:56
 * description：
 * ******************************
 */
@Module
public class ExamModule {

    @ActivityScope
    @Provides
    TestBean testBean(){
        return new TestBean();
    }

    //传参方式1
//    IView iView;
//    public ExamModule(IView iView) {
//        this.iView = iView;
//    }
//
//    @Provides
//    IView iView() {
//        return iView;
//    }
    Context context;
    public ExamModule(Context context) {
        this.context = context;
    }
    @Provides
    Context context(){
        return context;
    }

    @DaggerNamed("LoginDialog")
    @Provides
    Dialog loginDialog(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setTitle("登录提示");
//        dialog.setOnCancelListener("取消");
        return dialog;
    }


}
