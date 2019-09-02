package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.whw.customview.R;

public class ObjectAnimatorActivity extends AppCompatActivity {


    private Button button9,button10,button11;
    private TextView textView;
    private MyCircleView myCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        button9=findViewById(R.id.button9);
        button10=findViewById(R.id.button10);
        button11=findViewById(R.id.button11);
        textView=findViewById(R.id.textView4);
        myCircleView=findViewById(R.id.my_circleview);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                doAlphaAnimation();
                doArgbAnimation();
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doMyViewAnimation();
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PropertyValuesHolder
                doPropertyValuesHolderAnimation();
            }
        });

    }

    private void doPropertyValuesHolderAnimation() {
        PropertyValuesHolder rotationHolder=PropertyValuesHolder.ofFloat("rotation",60,-60,40,-40,20,-20,10,-10,0);
        PropertyValuesHolder colorHolder=PropertyValuesHolder.ofInt("backgroundColor",0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
        ObjectAnimator objectAnimator=ObjectAnimator.ofPropertyValuesHolder(textView,rotationHolder,colorHolder);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    /**
     * 透明动画
     */
    private void doAlphaAnimation() {
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"alpha",1,0,1);
        setAnimation(objectAnimator);
    }

    /**
     * 旋转
     */
    private void doRotationAnimation() {
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"rotation",0,180,0);
        setAnimation(objectAnimator);
    }

    /**
     * 绕x轴旋转
     */
    private void doRotatioXnAnimation() {
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"rotationX",0,180,0);
        setAnimation(objectAnimator);
    }

    /**
     * 绕y轴旋转
     */
    private void doRotationYAnimation() {
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,"rotationY",0,180,0);
        setAnimation(objectAnimator);
    }

    /**
     * 自定义view动画 ，ObjectAnimator.ofInt会通过myCircleView 找到PointRadius 方法进行调用
     */
    private void doMyViewAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(myCircleView,"PointRadius",0,300,100);
        setAnimation(objectAnimator);
    }

    private void doArgbAnimation(){
        ObjectAnimator objectAnimator=ObjectAnimator.ofInt(textView,"BackgroundColor",0xffff00ff, 0xffffff00, 0xffff00ff);
        setAnimation(objectAnimator);
    }

    private void setAnimation(ObjectAnimator objectAnimator) {
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

}
