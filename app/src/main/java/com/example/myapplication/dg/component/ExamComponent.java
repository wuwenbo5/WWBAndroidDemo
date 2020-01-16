package com.example.myapplication.dg.component;

import com.example.myapplication.ExampActivity;
import com.example.myapplication.IView;
import com.example.myapplication.dg.ActivityScope;
import com.example.myapplication.dg.module.ExamModule;

import dagger.BindsInstance;
import dagger.Component;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/11 10:13
 * description：
 * ******************************
 */
@ActivityScope
@Component(modules = ExamModule.class)
public interface ExamComponent {
    void inject(ExampActivity exampActivity);

//    IView iView();
//    @Component.Builder
//    interface Builder{
//        @BindsInstance
//        Builder iView(IView iView);
//
//        ExamComponent build();
//    }
}
