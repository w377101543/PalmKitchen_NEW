package com.gold.palm.palmkitchen_new.view.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.presenter.Guide.GuidePresenter;
import com.gold.palm.palmkitchen_new.ui.IndicatorView;
import com.gold.palm.palmkitchen_new.view.view.IGuideView;

import butterknife.BindView;

public class GuideActivity extends BaseActivity implements IGuideView {
    @BindView(R.id.guide_view_pager)
    ViewPager pager;
    @BindView(R.id.guide_indicator)
    IndicatorView indicatorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_guide;
    }
    private GuidePresenter presenter;
    @Override
    protected void initViews() {
        super.initViews();
        presenter = new GuidePresenter(this);
        setPagerAdapter();
        indicatorSetWithPager();
    }
    public void guideSkip(View view){
        Toast.makeText(this,"先逛逛",Toast.LENGTH_SHORT).show();
    }
    public void guideLogin(View view){
        Toast.makeText(this,"手机登陆",Toast.LENGTH_SHORT).show();
    }
    public void qqLogin(View view){
        Toast.makeText(this,"QQ登陆",Toast.LENGTH_SHORT).show();
    }
    public void wxLogin(View view){
        Toast.makeText(this,"微信登陆",Toast.LENGTH_SHORT).show();
    }
    public void xlLogin(View view){
        Toast.makeText(this,"新浪登陆",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void indicatorSetWithPager() {
        indicatorView.setViewPager(pager);
    }

    @Override
    public void setPagerAdapter() {
        presenter.setPagerAdapter(pager);
    }
}
