package com.example.x.ksonviewlianxi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author：x
 * @E-mail：
 * @Date：2019/7/23 14:21
 * @Description：描述信息
 */
public class DotRandView extends View {
    List<Point> list = new ArrayList<>();
    private Paint dotPaint;
    private Paint rectpaint;
    private Paint sdotPaint;

    public DotRandView(Context context) {
        super(context,null);
    }

    public DotRandView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public DotRandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(context,attrs);
    }

    private void initPaint(Context context, AttributeSet attrs) {
        dotPaint = new Paint();
        dotPaint.setStyle(Paint.Style.FILL);
        dotPaint.setAntiAlias(true);
        dotPaint.setColor(ContextCompat.getColor(getContext(),R.color.colorAccent));

        rectpaint = new Paint();
        rectpaint.setStyle(Paint.Style.STROKE);
        rectpaint.setStrokeWidth(10);
        rectpaint.setAntiAlias(true);
        rectpaint.setColor(ContextCompat.getColor(getContext(),  R.color.colorPrimaryDark));

        sdotPaint = new Paint();
        sdotPaint.setStyle(Paint.Style.FILL);
        sdotPaint.setAntiAlias(true);
        sdotPaint.setColor(ContextCompat.getColor(getContext(),  R.color.colorPrimaryDark));

    }
    private  int x,y;
    private int destX,destY;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Point point:list){
            if(point.x>x&&point.x<destX&&point.y>y&&point.y<destY){
                canvas.drawCircle(point.x,point.y,20,sdotPaint);
            }else {
                canvas.drawCircle(point.x,point.y,20,dotPaint);

            }
        }
        canvas.drawRect(x,y,destX,destY,rectpaint);

    }
    public void addDot(){
        int cx = new Random().nextInt(getScreenWidthOrHeight(true));
        int cy = new Random().nextInt(getScreenWidthOrHeight(false));
        Point point = new Point();
        point.x=cx;
        point.y=cy;
        list.add(point);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = (int) event.getX();
                y = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                destX = (int) event.getX();
                destY = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    private int getScreenWidthOrHeight(boolean width) {
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (width){
            return dm.widthPixels;
        }else{
            return dm.heightPixels;
        }

    }

}
