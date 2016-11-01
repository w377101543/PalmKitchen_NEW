package com.gold.palm.palmkitchen_new.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.gold.palm.palmkitchen_new.utils.AppUtils;

import butterknife.ButterKnife;

/**
 * Created by Wang on 2016/10/25.
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        AppUtils.setStatusBarColor(this, Color.WHITE);
        ButterKnife.bind(this);
        initViews();
    }

    protected void initViews() {
    }

    protected abstract int getContentViewResId();
    protected void setFullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
