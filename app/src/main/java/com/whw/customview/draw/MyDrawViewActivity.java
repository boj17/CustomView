package com.whw.customview.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.whw.customview.R;

public class MyDrawViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_draw_view);
        final MyDrawView1 myDrawView = findViewById(R.id.my_draw_view);
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDrawView.reset();
            }
        });
    }
}
