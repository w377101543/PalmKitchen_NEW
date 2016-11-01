package com.gold.palm.palmkitchen_new.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.presenter.Welcome.IWelcomePresenter;
import com.gold.palm.palmkitchen_new.presenter.Welcome.WelcomePresenter;
import com.gold.palm.palmkitchen_new.utils.AppUtils;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);
        IWelcomePresenter presenter = new WelcomePresenter(this,new Intent());
        presenter.startJump();
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_welcome;
    }
}
