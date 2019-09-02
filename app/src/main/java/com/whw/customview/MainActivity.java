package com.whw.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout=findViewById(R.id.root);
//        frameLayout.addView(new MyView(this));
//        frameLayout.addView(new MyView1(this));
//        frameLayout.addView(new MyRegionView(this));
        frameLayout.addView(new MyCanvasView(this));


    }
}
