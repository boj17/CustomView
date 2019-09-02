package com.whw.customview.animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;


public class MyCircleView extends View {

    private Point mPoint = new Point(100);

    public MyCircleView(Context context) {
        super(context);
    }

    public MyCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint != null) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeWidth(5);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(350, 500, mPoint.getRedius(), paint);
        }
    }

    public void setPointRadius(int radius) {
        mPoint.setRedius(radius);
        invalidate();
    }

    public void doAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyEvaluator(), new Point(100), new Point(200));
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mPoint = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }
    //自定义 Evaluator（Evaluator其实就是一个转换器，他能把小数进度转换成对应的数值位置）
    private class MyEvaluator implements TypeEvaluator<Point> {
        @Override
        public Point evaluate(float v, Point point, Point t1) {
            int startInt = point.getRedius();
            int endInt = t1.getRedius();
            int curInt = (int) (startInt + v * (endInt - startInt));

            Point point1 = new Point(curInt);
            return point1;
        }
    }
}
