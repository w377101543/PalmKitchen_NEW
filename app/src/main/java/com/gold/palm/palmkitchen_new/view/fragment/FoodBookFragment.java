package com.gold.palm.palmkitchen_new.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.adapter.BaseFragmentPagerAdapter;
import com.gold.palm.palmkitchen_new.view.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Wang on 2016/10/20.
 */

public class FoodBookFragment extends BaseFragment {
    @BindView(R.id.food_book_pager)
    ViewPager pager;
    @BindView(R.id.food_book_tab)
    TabLayout tablayout;
    @BindView(R.id.food_book_search)
    ImageView searchImg;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected int getViewResId() {
        return R.layout.fragment_food_book;
    }

    private BaseFragmentPagerAdapter adapter;
    @Override
    protected void initViews() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new IngredientFragment());
        fragments.add(new AssortmentFragment());
        List<String> stringList = new ArrayList<>();
        stringList.add("推荐");
        stringList.add("食材");
        stringList.add("分类");
        adapter = new BaseFragmentPagerAdapter(getChildFragmentManager(),fragments,stringList);
        pager.setOffscreenPageLimit(0);
        pager.setAdapter(adapter);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setupWithViewPager(pager,false);
    }
    @OnClick({R.id.food_book_search})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.food_book_search:
                startActivity(new Intent(getContext(), SearchActivity.class));
                return;
        }
    }
}
