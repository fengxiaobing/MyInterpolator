package com.example.myinterpolator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myinterpolator.Interpolator.MyInterpolator;

public class MyInterpolatorActivity extends AppCompatActivity implements View.OnClickListener {
        Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_interpolator);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        float curTranslationX = button.getTranslationX();
//        // 获得当前按钮的位置
//
//        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"translationX",curTranslationX,500,curTranslationX);
//// 创建动画对象 & 设置动画
//        // 表示的是:
//        // 动画作用对象是mButton
//        // 动画作用的对象的属性是X轴平移
//        // 动画效果是:从当前位置平移到 x=500 再平移到初始位置
//        animator.setDuration(5000);
//        animator.setInterpolator(new MyInterpolator());
//        // 设置插值器
//        animator.start();
//        // 启动动画

        button.animate().translationX(500).setDuration(2000).setInterpolator(new MyInterpolator());

    }
}
