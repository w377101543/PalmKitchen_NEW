package com.gold.palm.palmkitchen_new.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Wang on 2016/10/29.
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> titles;
    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> list,List<String> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
