package com.gold.palm.palmkitchen_new.presenter.Main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import android.widget.CheckedTextView;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.model.main.MainModel;
import com.gold.palm.palmkitchen_new.utils.FileUtils;

import java.util.List;

/**
 * Created by Wang on 2016/10/29.
 */

public class MainPresenter implements IMainPresenter {
    private int currentIndex = -1;
    private FragmentManager fm;
    private Fragment[] fragments;
    private CheckedTextView[] ct;
    private MainModel model;
    private Context context;
    public MainPresenter(Context context,FragmentManager fm,Fragment[] fragments,CheckedTextView[] ct) {
        this.fm = fm;
        this.fragments = fragments;
        this.ct = ct;
        model = new MainModel();
        this.context = context;
    }

    @Override
    public void switchTabs(int i) {
        if(currentIndex == i) return;
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = fm.findFragmentByTag(fragments[i].getClass().getCanonicalName());
        if(fragment == null){
            transaction.add(R.id.main_fragment_container,fragments[i],fragments[i].getClass().getCanonicalName());
        }else {
            transaction.show(fragment);
        }
        if(currentIndex!=-1){
            transaction.hide(fragments[currentIndex]);
            ct[currentIndex].setChecked(false);
        }
        transaction.commit();
        ct[i].setChecked(true);
        currentIndex = i;
    }

    @Override
    public void getNetHot() {
        model.getHotSearch(context);
    }

}
