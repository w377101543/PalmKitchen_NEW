package com.gold.palm.palmkitchen_new.presenter.Welcome;

import android.content.Context;
import android.content.Intent;

import com.gold.palm.palmkitchen_new.model.Welcome.WelcomeModel;

/**
 * Created by Wang on 2016/10/29.
 */

public class WelcomePresenter implements IWelcomePresenter {
    private WelcomeModel model;
    private Context context;
    private Intent intent;
    public WelcomePresenter(Context context,Intent intent) {
        model = new WelcomeModel();
        this.context = context;
        this.intent = intent;
    }

    @Override
    public void startJump() {
        model.jumpActivity(context,intent);
    }
}
