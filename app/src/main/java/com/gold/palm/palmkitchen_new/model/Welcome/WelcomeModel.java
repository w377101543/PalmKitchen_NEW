package com.gold.palm.palmkitchen_new.model.Welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.utils.AppUtils;
import com.gold.palm.palmkitchen_new.view.activity.GuideActivity;
import com.gold.palm.palmkitchen_new.view.activity.MainActivity;
import com.gold.palm.palmkitchen_new.view.activity.WelcomeActivity;

/**
 * Created by Wang on 2016/10/29.
 */

public class WelcomeModel implements IWelcomeModel {
    @Override
    public void jumpActivity(final Context context, final Intent intent) {
        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == Constants.WELCOME_ACTIVITY_DELAY_WHAT){
                    if(AppUtils.isFirstLaunch(context)){
                        intent.setClass(context,GuideActivity.class);
                    }else {
                        intent.setClass(context,MainActivity.class);
                    }
                    context.startActivity(intent);
                    WelcomeActivity aty = (WelcomeActivity) context;
                    aty.finish();
                    System.gc();
                }
                return false;
            }
        }).sendEmptyMessageDelayed(Constants.WELCOME_ACTIVITY_DELAY_WHAT,Constants.WELCOME_ACTIVITY_DELAY_TIME);
    }
}
