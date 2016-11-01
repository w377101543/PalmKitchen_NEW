package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Point;
import android.media.Image;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/11/1.
 */

public class WImageViewI extends ImageView {
    public WImageViewI(Context context) {
        super(context);
    }

    public WImageViewI(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int imgWidth = width/5*3;
        int imgHeight = (int) (imgWidth/1.2);
        setMeasuredDimension(imgWidth,imgHeight);
    }
}
