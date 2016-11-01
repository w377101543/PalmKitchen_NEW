package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/10/31.
 */

public class WImageViewS extends ImageView {
    public WImageViewS(Context context) {
        super(context);
    }

    public WImageViewS(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = widthMeasureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
