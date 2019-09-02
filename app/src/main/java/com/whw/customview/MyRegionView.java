package com.whw.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

public class MyRegionView extends View {
    public MyRegionView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

//        Region region=new Region(10,10,100,100);
//        region.set(100,100,200,200);
//        drawRegion(canvas,region,paint);

        //3、使用SetPath（）构造不规则区域
//        Path path=new Path();
//        RectF rectF=new RectF(50,50,200,500);
//        path.addOval(rectF, Path.Direction.CCW);
//        Region region=new Region();
//        //region和path 取交集
//        region.setPath(path,new Region(50,50,200,200));
//        drawRegion(canvas,region,paint);

        //区域的合并、交叉等操作
        //创建两个个相交的矩形
        Rect rectF=new Rect(100,150,400,250);
        Rect rectF1=new Rect( 200,50,300,350);
        canvas.drawRect(rectF,paint);
        canvas.drawRect(rectF1,paint);
        //创建相对应的区域
        Region region=new Region(rectF);
        Region region1=new Region(rectF1);

        //   假设用region1  去组合region2
        //        public enum Op {
        //            DIFFERENCE(0), //最终区域为region1 与 region2不同的区域
        //            INTERSECT(1), // 最终区域为region1 与 region2相交的区域
        //            UNION(2),      //最终区域为region1 与 region2组合一起的区域
        //            XOR(3),        //最终区域为region1 与 region2相交之外的区域
        //            REVERSE_DIFFERENCE(4), //最终区域为region2 与 region1不同的区域
        //            REPLACE(5); //最终区域为为region2的区域
        //        }



        //取两个区域的交集
//        region.op(region1, Region.Op.INTERSECT);
        //补集
//        region.op(region1, Region.Op.DIFFERENCE);
        //替换
//        region.op(region1, Region.Op.REPLACE);
        //反转补集
//        region.op(region1, Region.Op.REVERSE_DIFFERENCE);
        //并集
//        region.op(region1, Region.Op.UNION);
        //异并集
        region.op(region1, Region.Op.XOR);


        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        drawRegion(canvas,region,paint);

    }

    //这个函数不懂没关系，下面会细讲
    private void drawRegion(Canvas canvas,Region rgn,Paint paint)
    {
        //矩形集枚举区域——RegionIterator类
        //首先，根据区域构建一个矩形集，然后利用next(Rect r)来逐个获取所有矩形，绘制出来，
        // 最终得到的就是整个区域，如果我们将上面的画笔Style从FILL改为STROKE，
        // 重新绘制椭圆路径，会看得更清楚。
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();

        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }


}
