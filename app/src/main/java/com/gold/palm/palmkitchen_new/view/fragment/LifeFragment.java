package com.gold.palm.palmkitchen_new.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.BaseFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by Wang on 2016/10/20.
 */

public class LifeFragment extends BaseFragment {
    @BindView(R.id.life_tablayout)
    TabLayout tablayout;
    @BindView(R.id.life_pager)
    ViewPager pager;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_life;
    }

    @Override
    protected void initViews() {
        initTab();
    }

    private void initTab() {
        List<String> stringList = new ArrayList<>();
        stringList.add("美食IP");
        stringList.add("健康IP");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new CateFragment());
        fragments.add(new HealthFragment());
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getChildFragmentManager(),fragments,stringList);
        pager.setAdapter(adapter);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setupWithViewPager(pager,false);
    }
}
