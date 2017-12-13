package com.example.myinterpolator.Interpolator;

import android.animation.TimeInterpolator;

/**
 * Created by Administrator on 2017/12/13.
 * 写一个自定义Interpolator：先减速后加速
 */

public class MyInterpolator implements TimeInterpolator{
    @Override
    public float getInterpolation(float input) {
        float result;
        if(input>0.5){
            result  = (float) (Math.sin(Math.PI*input)/2);
        }else {
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }


        return result;
        // 返回的result值 = 随着动画进度呈先减速后加速的变化趋势
    }
}
