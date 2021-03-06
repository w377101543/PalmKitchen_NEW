package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Wang on 2016/11/1.
 */

public class WTextView extends TextView {
    public WTextView(Context context) {
        super(context);
    }

    private int screenWidth, screenHeight;

    public WTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int itemWidth = (int) ((screenWidth - TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,70,getResources().getDisplayMetrics()))/5);
//        itemWidth = (int) (itemWidth - TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,25,getResources().getDisplayMetrics()));
        int itemHeight = (int) (itemWidth/2.2);
        setMeasuredDimension(itemWidth,itemHeight);
    }
}
