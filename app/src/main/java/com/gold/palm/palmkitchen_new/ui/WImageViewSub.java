package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/10/31.
 */

public class WImageViewSub extends ImageView {
    public WImageViewSub(Context context) {
        super(context);
    }

    public WImageViewSub(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width/3;
        setMeasuredDimension(width,height);
    }
}
