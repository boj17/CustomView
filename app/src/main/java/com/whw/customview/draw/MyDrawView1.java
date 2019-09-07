package com.whw.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 手指曲线(采用quaTo)
 */
public class MyDrawView1 extends View {

    private Paint mPaint;
    private Path mPath;
    private float mPreX;
    private float mPreY;

    public MyDrawView1(Context context) {
        super(context);
        init();
    }

    public MyDrawView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyDrawView1(Context context, AttributeSet attrs, int defStyleAttr) {
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
                mPreX=event.getX();
                mPreY=event.getY();
                return true;

            case MotionEvent.ACTION_MOVE:

                //使用Path.lineTo（）的时候，是直接把手指触点A,B,C给连起来。
                //而钢笔工具要实现这三个点间的流畅过渡，就只能将这两个线段的中间点做为起始点和结束点，
                // 而将手指的倒数第二个触点B做为控制点。
                float endX=(mPreX+event.getX())/2;
                float endY=(mPreY+event.getY())/2;


                mPath.quadTo(mPreX,mPreY,endX,endY);
                //postInvalidate()   invalidate() 区别
                //postInvalidate 在ui主线程执行 但效率低
                //invalidate 不一定在主线程执行，有可能出错
//                postInvalidate();
                mPreY=event.getY();
                mPreX=event.getX();
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
