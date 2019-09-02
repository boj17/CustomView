package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.whw.customview.R;

import org.w3c.dom.Text;

public class AnimatorSetActivity extends AppCompatActivity {

    private Button button;
    private TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        button=findViewById(R.id.button13);
        textView1=findViewById(R.id.textView5);
        textView2=findViewById(R.id.textView6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                doPlaySequentiallyAnimator();
                doAnimationBuilder();
            }
        });

    }
    //自由设置动画顺序——AnimatorSet.Builder
    private void doAnimationBuilder() {
        //变色动画
        ObjectAnimator objectAnimator1=ObjectAnimator.ofInt(textView1,"backgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        //移动动画
        ObjectAnimator objectAnimator11=ObjectAnimator.ofFloat(textView1,"translationY",0,300,0);

        ObjectAnimator objectAnimator12=ObjectAnimator.ofFloat(textView2,"translationY",0,300,0);

        AnimatorSet animatorSet=new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(objectAnimator1);
        builder.with(objectAnimator11);
        builder.before(objectAnimator12);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void doPlaySequentiallyAnimator() {
        //变色动画
        ObjectAnimator objectAnimator1=ObjectAnimator.ofInt(textView1,"backgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        //移动动画
        ObjectAnimator objectAnimator11=ObjectAnimator.ofFloat(textView1,"translationY",0,300,0);
        objectAnimator11.setRepeatCount(ValueAnimator.INFINITE);
        //移动动画
        ObjectAnimator objectAnimator12=ObjectAnimator.ofFloat(textView2,"translationY",0,300,0);
        objectAnimator12.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet animatorSet=new AnimatorSet();
        // textView1先做变色，再移动，再textView2做移动（先后顺序播放）
//        animatorSet.playSequentially(object   Animator1,objectAnimator11,objectAnimator12);
        // 同一时间开始播放（同一时间点开始）
        animatorSet.playTogether(objectAnimator1,objectAnimator11,objectAnimator12);
        animatorSet.setDuration(1000);
        animatorSet.start();

    }
}
