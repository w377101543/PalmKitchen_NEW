package com.gold.palm.palmkitchen_new.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.BaseFragmentPagerAdapter;
import com.gold.palm.palmkitchen_new.ui.ScrollCameraView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by Wang on 2016/10/20.
 */

public class SheQuFragment extends BaseFragment {
    @BindView(R.id.shequ_tab)
    TabLayout tabLayout;
    @BindView(R.id.shequ_pager)
    ViewPager pager;
    @BindView(R.id.shequ_camera_layout)
    RelativeLayout cameraLayout;
    @BindView(R.id.shequ_camera)
    ImageView camera;
    @Override
    protected int getViewResId() {
        return R.layout.fragment_she_qu;
    }

    @Override
    protected void initViews() {
        List<String> stringList = new ArrayList<>();
        stringList.add("关注");
        stringList.add("推荐");
        stringList.add("最新");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FollowFragment());
        fragments.add(new NominateFragment());
        fragments.add(new NewFragment());
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addTab(tabLayout.newTab().setText(stringList.get(0)),0,false);
        tabLayout.addTab(tabLayout.newTab().setText(stringList.get(1)),1,true);
        tabLayout.addTab(tabLayout.newTab().setText(stringList.get(2)),2,false);
        tabLayout.setupWithViewPager(pager,false);
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getChildFragmentManager(),fragments,stringList);
        pager.setAdapter(adapter);
    }
}
