package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.whw.customview.MainActivity;
import com.whw.customview.R;

public class ValueAnimation2Activity extends AppCompatActivity {


    private Button button5,button6,button7;
    private TextView textView;
    private MyCircleView myCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation2);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        textView=findViewById(R.id.textView3);
        myCircleView=findViewById(R.id.my_circleview);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAnimation();
                Toast.makeText(getApplicationContext(),"点击了",Toast.LENGTH_SHORT).show();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCircleView.doAnimation();
            }
        });
    }

    private void doAnimation(){
        ValueAnimator  valueAnimator=ValueAnimator.ofObject(new MyEvaluator(),new Character('A'),new Character('Z'));
        valueAnimator.setDuration(10000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char value= (char) valueAnimator.getAnimatedValue();
                Log.d("haha", "onAnimationUpdate: "+value);
                textView.setText(String.valueOf(value));
            }
        });
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }

    private class MyEvaluator implements TypeEvaluator<Character> {

        @Override
        public Character evaluate(float function, Character startValue, Character endValue) {
            int startInt=(int)startValue;
            int endInt=(int)endValue;
            int curInt= (int) (startInt+function*(endInt-startInt));
            Log.d("haha", "evaluate: ");
            char result= (char) curInt;
            return result;
        }
    }
}
