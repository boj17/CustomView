package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.whw.customview.R;

public class AnimationSet2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button, button1, button2, button3, button4, button5;
    private boolean mIsMenuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_set2);
        button = findViewById(R.id.menu);
        button1 = findViewById(R.id.item1);
        button2 = findViewById(R.id.item2);
        button3 = findViewById(R.id.item3);
        button4 = findViewById(R.id.item4);
        button5 = findViewById(R.id.item5);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu:
                if (!mIsMenuOpen){
                    mIsMenuOpen=true;
                    doOpenAnimation(button1,0,5,300);
                    doOpenAnimation(button2,1,5,300);
                    doOpenAnimation(button3,2,5,300);
                    doOpenAnimation(button4,3,5,300);
                    doOpenAnimation(button5,4,5,300);
                }else {
                    mIsMenuOpen=false;
                    doCloseAnimation(button1,0,5,300);
                    doCloseAnimation(button2,1,5,300);
                    doCloseAnimation(button3,2,5,300);
                    doCloseAnimation(button4,3,5,300);
                    doCloseAnimation(button5,4,5,300);
                }

                break;
        }
    }

    private void doCloseAnimation(View view,int index,float total,int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        //获取弧度值
        double degree = Math.toRadians(90)/(total - 1) * index;

        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet animatorSet=new AnimatorSet();

        animatorSet.playTogether(ObjectAnimator.ofFloat(view,"translationY",translationY,0),
                ObjectAnimator.ofFloat(view,"translationX",translationX,0),
                ObjectAnimator.ofFloat(view,"scaleX",1,0.1f),
                ObjectAnimator.ofFloat(view,"scaleY",1,0.1f),
                ObjectAnimator.ofFloat(view,"alpha",1,0.1f));
        animatorSet.setDuration(1000);
        animatorSet.start();
    }

    private void doOpenAnimation(View view,int index,int total,int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        //获取弧度值
        double degree = Math.toRadians(90)/(total - 1) * index;

        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet animatorSet=new AnimatorSet();

        animatorSet.playTogether(ObjectAnimator.ofFloat(view,"translationY",0,translationY),
                ObjectAnimator.ofFloat(view,"translationX",0,translationX),
                ObjectAnimator.ofFloat(view,"scaleX",0,1),
                ObjectAnimator.ofFloat(view,"scaleY",0,1),
                ObjectAnimator.ofFloat(view,"alpha",0,1));
        animatorSet.setDuration(1000);
        animatorSet.start();
    }
}
