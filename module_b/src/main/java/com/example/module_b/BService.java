package com.example.module_b;

import android.util.Log;

import com.example.module_base.InterfaceB;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/17 16:30
 * description：
 * ******************************
 */
@Service
public class BService implements InterfaceB {
    @Override
    public void method_b() {
        Log.e("interface","-----------B service");
    }
}
