package com.example.myapplication.anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.LayoutTransition;
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
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import static android.animation.ValueAnimator.REVERSE;
import static android.view.View.VISIBLE;

public class AnimActivity extends AppCompatActivity {
    ObjectAnimator objectAnimator;
    LinearLayout layout;
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
        layout = findViewById(R.id.llLayoutAnimator);
        final TextView textView1 = findViewById(R.id.tv_LayoutAnimator);
//        final LayoutTransition mTransitioner = new LayoutTransition();
//        /**
//         * 添加View时过渡动画效果
//         */
//        ObjectAnimator addAnimator = ObjectAnimator.ofFloat(null, "rotationY", 0, 90,0).
//                setDuration(mTransitioner.getDuration(LayoutTransition.APPEARING));
//        mTransitioner.setAnimator(LayoutTransition.APPEARING, addAnimator);
//
//        /**
//         * 移除View时过渡动画效果
//         */
//        ObjectAnimator removeAnimator = ObjectAnimator.ofFloat(null, "rotationX", 0, -90, 0).
//                setDuration(mTransitioner.getDuration(LayoutTransition.DISAPPEARING));
//        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, removeAnimator);
//
//        /**
//         * view 动画改变时，布局中的每个子view动画的时间间隔
//         */
//        mTransitioner.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
//        mTransitioner.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);
//
//        layout.setLayoutTransition(mTransitioner);
//        layout.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                layout.clearAnimation();
//                layout.animate().alpha(0.5f).rotation(360).scaleX(1f).scaleY(1f)
//                        .translationX(50).translationY(250).setDuration(5000);
//                if (i<=5)
//                    addView();
//                else removeView();
//            }
//        });
//通过加载XML动画设置文件来创建一个Animation对象；
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.slide_in_left);   //得到一个LayoutAnimationController对象；
        LayoutAnimationController controller = new LayoutAnimationController(animation);   //设置控件显示的顺序；
        controller.setOrder(LayoutAnimationController.ORDER_REVERSE);   //设置控件显示间隔时间；
        controller.setDelay(0.5f);   //为ListView设置LayoutAnimationController属性；
        layout.setLayoutAnimation(controller);
        layout.startLayoutAnimation();
    }

    int i=0;
    public void addView() {
        i++;
        Button button = new Button(this);
        button.setText("布局动画_" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.addView(button, Math.min(0, layout.getChildCount()), params);
    }

    public void removeView() {
        i--;
        if (i > 0)
            layout.removeViewAt(1);
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
