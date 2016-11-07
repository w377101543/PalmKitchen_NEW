package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/11/6.
 */

public class StickyCircleView extends ImageView {
    private Paint paint;
    private float radius;
    private float alpha = 1.0f;
    public StickyCircleView(Context context) {
        super(context);
        init();
    }

    public StickyCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,radius+(getWidth()-getPaddingLeft()-getPaddingRight())/2,paint);
        setAlpha(alpha);
        radius += 0.6;
        alpha -= 0.020;
        if(radius >= getWidth()/2-(getWidth()-getPaddingLeft()-getPaddingRight())/2){
            radius = 0;
            alpha = 1.0f;
        }
        postInvalidateDelayed(50);
    }

}
