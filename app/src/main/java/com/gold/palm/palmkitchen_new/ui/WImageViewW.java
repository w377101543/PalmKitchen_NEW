package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/10/31.
 */

public class WImageViewW extends ImageView {
    public WImageViewW(Context context) {
        super(context);
        init(context);
    }

    public WImageViewW(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private int screenWidth,screenHeight;
    private void init(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = (int) (widthMeasureSpec*1.78);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
