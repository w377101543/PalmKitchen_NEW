package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/10/31.
 */

public class WImageViewSub extends ImageView {
    public WImageViewSub(Context context) {
        super(context);
        init(context);
    }

    public WImageViewSub(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private int screenWidth, screenHeight;

    private void init(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int width = (int) ((int) ((screenWidth - TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,getResources().getDisplayMetrics()))/5*2) - TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5,getResources().getDisplayMetrics()));
        int width = (int) (screenWidth/5*2 - TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15,getResources().getDisplayMetrics()));
        int height = (int) (width / 2.2);
        setMeasuredDimension(width, height);
    }
}
