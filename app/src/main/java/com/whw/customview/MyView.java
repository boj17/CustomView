package com.whw.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义控件之绘图篇（一）：概述及基本几何图形绘制
 */
public class MyView extends View {

    Context m_context;
    Paint paint;

    public MyView(Context context) {
        super(context);
        m_context=context;
        init();
    }

    private void init(){
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
//        paint.setShadowLayer(10,15,15,Color.GREEN);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(255,255,255);
        //画圆
//        canvas.drawCircle(190,200,150,paint);

        //画线
//        canvas.drawLine(200,200,300,300,paint);
        //画多条线
//        float[] pts={10,10,100,100,200,200,400,400};
//        canvas.drawLines(pts,paint);
        //画点
//        paint.setStrokeWidth(25);
//        canvas.drawPoint(100,100,paint);
        //画多个点
//        paint.setStrokeWidth(25);
//        float[] pts={10,10,100,100,200,200,400,400};
        //float[] pts:点的合集，与上面直线一直，样式为｛x1,y1,x2,y2,x3,y3,……｝
        //int offset:集合中跳过的数值个数，注意不是点的个数！一个点是两个数值；
        //count:参与绘制的数值的个数，指pts[]里人数值个数，而不是点的个数，因为一个点是两个数值
//        canvas.drawPoints(pts,0,4,paint);

        //画矩形 rect rectf 两种效果是一样的
//
        //画圆角矩形
//        RectF rectf=new RectF(120,10,210,100);
//        canvas.drawRoundRect(rectf,20,10,paint);
        // 画椭圆 椭圆是根据矩形生成的，以矩形的长为椭圆的X轴，矩形的宽为椭圆的Y轴，建立的椭圆图形
//        RectF rectF=new RectF(10,10,400,200);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRect(rectF,paint);
//        paint.setColor(Color.GREEN);
//        canvas.drawOval(rectF,paint);
        // 画弧 弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF=new RectF(10,10,100,100);
        canvas.drawArc(rectF,0,90,true,paint);
        RectF rectF1=new RectF(150,10,250,100);
        canvas.drawArc(rectF1,0,90,false,paint);
        canvas.drawArc(300,10,400,100,0,90,true,paint);
    }
}
