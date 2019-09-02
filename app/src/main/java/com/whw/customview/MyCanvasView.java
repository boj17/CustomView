package com.whw.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyCanvasView extends View {

    private Paint paint;

    public MyCanvasView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect=new Rect(10,10,200,100);
        canvas.drawRect(rect,paint);
//        //平移
//        canvas.translate(100,100);
//        //旋转
//        canvas.rotate(30);
        //缩放
//        canvas.scale(2,2);
//        paint.setColor(Color.GREEN);
        //扭曲（斜切）
//        canvas.skew(1.732f,0);
//        canvas.drawRect(rect,paint);
        //裁剪
//        canvas.drawColor(Color.RED);
//        canvas.clipRect(rect);
//        canvas.drawColor(Color.GREEN);

        //六、画布的保存与恢复（save()、restore()）

    }
}
