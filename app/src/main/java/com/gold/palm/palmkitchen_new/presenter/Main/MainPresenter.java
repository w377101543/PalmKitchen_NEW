package com.gold.palm.palmkitchen_new.presenter.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CheckedTextView;

import com.gold.palm.palmkitchen_new.R;

/**
 * Created by Wang on 2016/10/29.
 */

public class MainPresenter implements IMainPresenter {
    private int currentIndex = -1;
    private FragmentManager fm;
    private Fragment[] fragments;
    private CheckedTextView[] ct;
    public MainPresenter(FragmentManager fm,Fragment[] fragments,CheckedTextView[] ct) {
        this.fm = fm;
        this.fragments = fragments;
        this.ct = ct;
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
}
