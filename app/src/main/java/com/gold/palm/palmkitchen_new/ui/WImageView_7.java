package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/11/2.
 */

public class WImageView_7 extends ImageView {
    public WImageView_7(Context context) {
        super(context);
    }

    public WImageView_7(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(widthMeasureSpec)/3);
    }
}
