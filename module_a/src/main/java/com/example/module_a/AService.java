package com.example.module_a;

import android.util.Log;

import com.example.module_base.InterfaceA;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/17 16:20
 * description：
 * ******************************
 */
@Service
public class AService implements InterfaceA {


    @Override
    public void method_a() {
        Log.e("interface","------------------"+"interface a");
    }
}
