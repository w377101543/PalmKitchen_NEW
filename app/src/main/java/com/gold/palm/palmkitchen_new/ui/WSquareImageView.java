package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/11/7.
 */

public class WSquareImageView extends ImageView {
    public WSquareImageView(Context context) {
        super(context);
    }

    public WSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(widthMeasureSpec));
    }
}
