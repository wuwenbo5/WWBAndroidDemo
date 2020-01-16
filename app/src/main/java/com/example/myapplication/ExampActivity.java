package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;

import com.example.myapplication.dg.DaggerNamed;
import com.example.myapplication.dg.component.DaggerExamComponent;
import com.example.myapplication.dg.module.ExamModule;
import com.example.myapplication.enity.Animal;
import com.example.myapplication.enity.TestBean;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

public class ExampActivity extends AppCompatActivity implements IView{
    private static final String TAG = "ExampActivity";

    @Inject
    TestBean bean;

    @DaggerNamed("LoginDialog")
    @Inject
    Dialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaggerExamComponent.builder()
                .examModule(new ExamModule(this))
//                .iView(this)
                .build()
                .inject(this);

        Animal animal = new Animal();
        animal.fly();

        animal = new Animal();
        int age = animal.getAge();
        Log.e(TAG, "true age: " + age);
        animal.setAge(20);
        animal.hurt();
        animal.getHeight();
        try {
            animal.hurtThrows();
        }catch (Exception e){ }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bean.println("测试 message");
                loginDialog.show();
            }
        });
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Toast show from activity", Toast.LENGTH_SHORT).show();
    }
}
