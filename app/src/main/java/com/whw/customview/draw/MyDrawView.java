package com.whw.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.telephony.mbms.MbmsErrors;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 手指曲线(采用lineTo)
 */
public class MyDrawView extends View {

    private Paint mPaint;
    private Path mPath;

    public MyDrawView(Context context) {
        super(context);
        init();
    }

    public MyDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(),event.getY());
                return true;

            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(),event.getY());
                //postInvalidate()   invalidate() 区别
                //postInvalidate 在ui主线程执行 但效率低
                //invalidate 不一定在主线程执行，有可能出错
                postInvalidate();
                invalidate();
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }

    public void reset(){
        mPath.reset();
        invalidate();
    }

}
