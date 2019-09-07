package com.whw.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * 贝塞尔曲线
 */
public class MyBézierView extends View {

    private Paint mPaint;
    private Path mPath;

    public MyBézierView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPath=new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(100,300);
        mPath.quadTo(200,200,300,300);
        mPath.quadTo(400,400,500,300);
        canvas.drawPath(mPath,mPaint);
    }
}
