package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.whw.customview.R;

public class ValueAnimatorActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonStart,btnCancle;
    ValueAnimator valueAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        textView=findViewById(R.id.textView2);
        buttonStart=findViewById(R.id.button4);
        btnCancle=findViewById(R.id.button3);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAnimation();
            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueAnimator= doAnimation1();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueAnimator.cancel();
            }
        });
    }




    private void doAnimation() {
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,400,0,300,0,200,0,100,0,50,0,20,0);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value= (int) valueAnimator.getAnimatedValue();
                textView.layout(value,value,value+textView.getWidth(),value+textView.getHeight());
            }
        });
        valueAnimator.start();
    }

    private ValueAnimator doAnimation1(){
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,400);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value= (int) valueAnimator.getAnimatedValue();
                textView.layout(textView.getLeft(),value,textView.getRight(),value+textView.getHeight());
            }
        });
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
        return valueAnimator;
    }
}
