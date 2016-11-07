package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by Wang on 2016/11/5.
 */

public class TagLayout extends LinearLayout {
    public TagLayout(Context context) {
        super(context);
    }
    private void init(){
        random = new Random();
    }
    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private Random random;
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        View view = getChildAt(0);
        View view2 = getChildAt(1);
        int left = random.nextInt(r-view.getWidth()-view2.getWidth());
        int top;
        if(view.getMeasuredHeight()>=view2.getMeasuredHeight()){
            top = random.nextInt(b-view.getHeight());
        }else {
            top = random.nextInt(b - view2.getHeight())+view2.getHeight()/2;
        }
        view.layout(left,top,left+view.getWidth(),top+view.getHeight());
        view2.layout(view.getRight(),view.getTop()-(view2.getHeight()-view.getHeight())/2,view.getRight()+view2.getWidth(),view.getTop()-(view2.getHeight()-view.getHeight())/2+view2.getHeight());
    }
}
