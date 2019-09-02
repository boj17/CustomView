package com.whw.customview.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.whw.customview.MainActivity;
import com.whw.customview.R;

import org.w3c.dom.Text;

public class XMLAnimatorActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanimator);
        button = findViewById(R.id.button14);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                doValueAnimator();
                doObjectAnimator();
            }
        });
    }

    private void doObjectAnimator() {
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(XMLAnimatorActivity.this, R.animator.object_animator);
        objectAnimator.setTarget(imageView);
        objectAnimator.start();
    }

    //ValueAnimator XML
    private void doValueAnimator() {
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(XMLAnimatorActivity.this, R.animator.animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                imageView.layout(animatedValue, animatedValue, animatedValue + imageView.getWidth(), animatedValue + imageView.getHeight());
            }
        });
        valueAnimator.start();
    }
}
