package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.whw.customview.R;

public class AnimationActivity extends AppCompatActivity {


    Button button;
    private TextView textView;
    Animation scaleAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scaleanim);
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,400);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value= (int) valueAnimator.getAnimatedValue();
                Log.d("haha", "onAnimationUpdate: "+value);
            }
        });
        valueAnimator.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(scaleAnimation);
            }
        });
    }
}
