package com.example.myapplication.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.myapplication.R;

import static android.animation.ValueAnimator.REVERSE;

public class AnimActivity extends AppCompatActivity {
    ObjectAnimator objectAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView = findViewById(R.id.tv_animation_view);
//        objectAnimator = ObjectAnimator.ofFloat(textView,"scaleY",0,1);
        objectAnimator = ObjectAnimator.ofFloat(textView, "rotationY", 0.0f, 360.0f);
        objectAnimator.setEvaluator(new FloatEvaluator());
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(1000);
        objectAnimator.start();

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                objectAnimator.start();
            }
        });

        TextView startAct = findViewById(R.id.tv_animation_activity);
        startAct.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //在调用了 startActivity 方法之后立即调用 overridePendingTransition 方法
                Intent intent = new Intent(AnimActivity.this, TargetActivity.class);
                startActivity(intent);
//                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            }
        });
        //value animation
        TextView startValue = findViewById(R.id.tv_animation_value);
        startValue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startValueAnimation(v);
            }
        });
        //value animation
        final TextView tvAnimSet = findViewById(R.id.tv_animation_set);
        tvAnimSet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //xml
//                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(AnimActivity.this,
//                        R.animator.animation_set);
//                set.setTarget(tvAnimSet);
//                set.start();
               //代码
                ObjectAnimator a1 = ObjectAnimator.ofFloat(tvAnimSet, "alpha", 1.0f, 0f);
                ObjectAnimator a2 = ObjectAnimator.ofFloat(tvAnimSet, "translationY", 0f, 200f);

                AnimatorSet animSet = new AnimatorSet();
                animSet.setDuration(5000);
                animSet.setInterpolator(new LinearInterpolator());
                animSet.playTogether(a1, a2); //两个动画同时执行
//                animSet.play(a1).after(a2); //先后执行
                animSet.start();
            }
        });
        //PropertyValuesHolder
        final TextView tv_PropertyValuesHolder = findViewById(R.id.tv_PropertyValuesHolder);

        final PropertyValuesHolder a1 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
        final PropertyValuesHolder a2 = PropertyValuesHolder.ofFloat("translationY", 0, tv_PropertyValuesHolder.getMeasuredWidth());

        tv_PropertyValuesHolder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofPropertyValuesHolder(tv_PropertyValuesHolder, a1, a2).setDuration(2000).start();
            }
        });
        //tv_Evaluators
        final TextView tv_Evaluators = findViewById(R.id.tv_Evaluators);
        tv_Evaluators.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimWithEvaluator(tv_Evaluators);
            }
        });
        //tv_Interpolators
        final TextView tv_Interpolators = findViewById(R.id.tv_Interpolators);
        tv_Interpolators.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0,800);
                valueAnimator.setDuration(5000);
                valueAnimator.setInterpolator(new AccelerateInterpolator());
                valueAnimator.setRepeatMode(REVERSE);
                valueAnimator.setRepeatCount(2);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation)
                    {
                        int xyPos = (int) animation.getAnimatedValue();
                        tv_Interpolators.setX(xyPos);   //通过属性值设置View属性动画
                    }
                });
                valueAnimator.start();
            }
        });
        //tv_ViewPropertyAnimator
        final TextView tv_ViewPropertyAnimator = findViewById(R.id.tv_ViewPropertyAnimator);
        tv_ViewPropertyAnimator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_ViewPropertyAnimator.animate().setDuration(3000).alpha(0.5f).rotationY(1.0f).x(1000f).start();
            }
        });
    }

    private void startAnimWithEvaluator(final TextView view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new float[2]); //设置属性值类型
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<float[]>()
        {
            @Override
            public float[] evaluate(float fraction, float[] startValue,
                                    float[] endValue)
            {
                //实现自定义规则计算的float[]类型的属性值
                float[] temp = new float[2];
                temp[0] = fraction * 200;
                temp[1] = (float)Math.random() * 100 * fraction;
                return temp;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float[] xyPos = (float[]) animation.getAnimatedValue();
                view.setX((int) xyPos[0]);   //通过属性值设置View属性动画
                view.setY((int) xyPos[1]);    //通过属性值设置View属性动画
            }
        });
    }

    private void startValueAnimation(final View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,800);
        valueAnimator.setTarget(view);
        valueAnimator.setDuration(3000).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value  = (float) animation.getAnimatedValue();
                Log.w("value","--------value = "+value );
                view.setX(value);
            }
        });
    }

}
