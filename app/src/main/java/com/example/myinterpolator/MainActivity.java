package com.example.myinterpolator;

import android.graphics.Path;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    Button btn_animal,btn_move;
    Interpolator[] interpolators = new Interpolator[13];
    Path interpolatorPath;

    {
        interpolatorPath = new Path();
        interpolatorPath.lineTo(0.25f, 0.25f);
        interpolatorPath.moveTo(0.25f, 1.5f);
        interpolatorPath.lineTo(1, 1);
        interpolators[0] = new AccelerateDecelerateInterpolator();
        interpolators[1] = new LinearInterpolator();
        interpolators[2] = new AccelerateInterpolator();
        interpolators[3] = new DecelerateInterpolator();
        interpolators[4] = new AnticipateInterpolator();
        interpolators[5] = new OvershootInterpolator();
        interpolators[6] = new AnticipateOvershootInterpolator();
        interpolators[7] = new BounceInterpolator();
        interpolators[8] = new CycleInterpolator(0.5f);
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath);
        interpolators[10] = new FastOutLinearInInterpolator();
        interpolators[11] = new FastOutSlowInInterpolator();
        interpolators[12] = new LinearOutSlowInInterpolator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.interpolatorSpinner);
        btn_animal = findViewById(R.id.btn_animal);
        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                btn_animal.animate()
                        .translationX(Utils.dpToPixel(150))
                        .setDuration(600)
                        .setInterpolator(interpolators[spinner.getSelectedItemPosition()])
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                btn_animal.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btn_animal.setTranslationX(0);
                                    }
                                }, 500);
                            }
                        });
            break;
        }
    }
}
