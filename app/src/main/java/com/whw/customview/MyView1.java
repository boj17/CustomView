package com.whw.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * 自定义控件之绘图篇（二）：路径及文字
 */
public class MyView1 extends View {

    private Paint paint;
    private Path path;
    private String text;

    public MyView1(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
//        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(80);
        text="五舅少女，沙拉汉达";
        path=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //直线路径
//        path.moveTo(10,10);//设置起点
//        path.lineTo(10,100);//第一条直线的终点，也是第二条直线的起点
//        path.lineTo(300,100);
//        path.lineTo(500,100);
//        path.close();//闭环
//        canvas.drawPath(path,paint);
        //矩形路径
//        RectF rectF1=new RectF(50,50,240,200);
//        path.addRect(rectF1, Path.Direction.CCW);//逆向生成
//        RectF rectF2=new RectF(290,50,482,200);
//        Path cwPath=new Path();
//        cwPath.addRect(rectF2, Path.Direction.CW);//顺向生成
//        canvas.drawPath(path,paint);
//        canvas.drawPath(cwPath,paint);
//        //根据路径方向写文字
//        String text="五舅少牛，沙拉汉达";
//        paint.setColor(Color.GRAY);
//        paint.setTextSize(35);
//        canvas.drawTextOnPath(text,path,0,18,paint);
//        canvas.drawTextOnPath(text,cwPath,0,18,paint);

        //圆角矩形路径
//        RectF rectF=new RectF(50,50,240,200);
//        path.addRoundRect(rectF,10,15, Path.Direction.CW);
//        RectF rectF1=new RectF(290,50,480,200);
//        float radii[] ={10,15,20,25,30,35,40,45};
//        path.addRoundRect(rectF1,radii, Path.Direction.CW);
//        canvas.drawPath(path,paint);

        //圆形路径
//        path.addCircle(200,200,100, Path.Direction.CCW);
//        canvas.drawPath(path,paint);

        //椭圆路径
//        RectF rectFf=new RectF(10,10,100,400);
//        path.addOval(rectFf, Path.Direction.CW);
//        canvas.drawPath(path,paint);

        //弧形路径
//        RectF rectFf=new RectF(10,10,100,400);
//        path.addArc(rectFf,0,90);
//        canvas.drawPath(path,paint);

        //文字

        // 绘图样式的区别
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawText(text,10,100,paint);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawText(text,10,200,paint);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text,10,300,paint);
//        paint.setStyle(Paint.Style.FILL);
         //文字样式设置及倾斜度正负区别
//        paint.setFakeBoldText(true);//设为粗体
//        paint.setUnderlineText(true);//带下划线
//        paint.setStrikeThruText(true);//带删除线
//        paint.setTextSkewX((float) -0.25);
//        canvas.drawText(text,10,100,paint);
//        paint.setTextSkewX((float) 0.25);
//        canvas.drawText(text,10,200,paint);

        //水平拉伸设置
//        canvas.drawText(text,10,100,paint);
//        paint.setTextScaleX(2);//设置水平拉伸
//        canvas.drawText(text,10,200,paint);
//        paint.setTextScaleX(1);
//        canvas.drawText(text,10,300,paint);
//        paint.setTextScaleX(2);
//        paint.setColor(Color.GREEN);
//        canvas.drawText(text,10,300,paint);

        //指定个个文字位置
//        float[] pos={10,80,10,160,10,240,10,320};
//        canvas.drawPosText("欢迎光临",pos,paint);

        //沿路径绘制
        //float hOffset  : 与路径起始点的水平偏移距离
        //float vOffset  : 与路径中心的垂直偏移量
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(45);
        path.addCircle(100,200,100, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        Path path1=new Path();
        path1.addCircle(300,200,100, Path.Direction.CCW);
        canvas.drawPath(path1,paint);
        paint.setColor(Color.GREEN);
        canvas.drawTextOnPath(text,path,0,0,paint);
        canvas.drawTextOnPath(text,path1,80,30,paint);
    }
}
