package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.CycleInterpolator;

import com.gold.palm.palmkitchen_new.R;

/**
 * Created by Wang on 2016/10/29.
 */

public class WLoadingView extends View {
    private float scale;
    private int maxColor,minColor;
    private Paint mPaint;
    public WLoadingView(Context context) {
        super(context);
        init();
    }

    public WLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WLoadingView);
        maxColor = a.getColor(R.styleable.WLoadingView_max_color, Color.BLACK);
        minColor = a.getColor(R.styleable.WLoadingView_min_color,Color.BLACK);
        scale = a.getDimension(R.styleable.WLoadingView_sscale,10);
        a.recycle();
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,scale/2,mPaint);
    }
    private ViewPropertyAnimator animator;
    private void init(){
        animator = this.animate().scaleX(0.5f).scaleY(0.5f).scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new CycleInterpolator(10));
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(maxColor);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        animator.start();
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if(!gainFocus&&animator!=null){
            animator.cancel();
        }
    }
}
