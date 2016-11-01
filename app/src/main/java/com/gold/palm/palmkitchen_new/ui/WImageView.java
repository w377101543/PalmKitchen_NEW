package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Wang on 2016/10/31.
 */

public class WImageView extends ImageView {
    public WImageView(Context context) {
        super(context);
        init(context);
    }

    public WImageView(Context context, AttributeSet attrs) {
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
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) (width/1.5);
        setMeasuredDimension(width,height);
    }
}
