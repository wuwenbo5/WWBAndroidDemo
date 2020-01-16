package com.example.myapplication.enity;

import android.util.Log;

/**
 * ******************************
 *
 * @author YOULU-wwb
 * date: 2020/1/14 14:07
 * description：
 * ******************************
 */
public class Animal {
    private static final String TAG = "Animal";

    private int age;

    public Animal() {
        this.age = 10;
    }

    public void setAge(int age) {
        Log.e(TAG, "setAge: ---------age = "+age);
        this.age = age;
    }

    public int getAge() {
        Log.e(TAG, "getAge: ----------");
        return this.age;
    }

    public void fly() {
        Log.e(TAG, this.toString() + "#fly");
    }

    public void hurtThrows(){
        int i = 4 / 0;
    }
    public void hurt(){
        try {
            int i = 4 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }


    static {
        Log.e(TAG, "static block");
    }
    public int getHeight() {
        return 0;
    }

    public int getHeight(int sex) {
        switch (sex) {
            case 0:
                return 163;
            case 1:
                return 173;
        }
        return 173;
    }

}
