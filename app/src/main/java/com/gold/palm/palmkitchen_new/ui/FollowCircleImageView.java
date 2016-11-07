package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Wang on 2016/11/6.
 */

public class FollowCircleImageView extends CircleImageView {
    public FollowCircleImageView(Context context) {
        super(context);
    }

    public FollowCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup parent = (ViewGroup) getParent();
        setMeasuredDimension(parent.getWidth()/7,heightMeasureSpec);
    }
}
