package com.gold.palm.palmkitchen_new.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Wang on 2016/11/7.
 */

public class ScrollCameraView extends RelativeLayout {
    public ScrollCameraView(Context context) {
        super(context);
    }

    public ScrollCameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private long time1;
    private long time2;
    public void setWithContent(RecyclerView recyclerView){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e("scroll",dy+"");
            }
        });
    }
    private void startAnimation(){

    }
}
