package com.gold.palm.palmkitchen_new.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import com.gold.palm.palmkitchen_new.R;
import com.gold.palm.palmkitchen_new.presenter.Main.MainPresenter;
import com.gold.palm.palmkitchen_new.view.fragment.FoodBookFragment;
import com.gold.palm.palmkitchen_new.view.fragment.FoodClassFragment;
import com.gold.palm.palmkitchen_new.view.fragment.OwnerFragment;
import com.gold.palm.palmkitchen_new.view.fragment.SheQuFragment;
import com.gold.palm.palmkitchen_new.view.view.IMainView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IMainView, View.OnClickListener {
    private MainPresenter presenter;
    private FragmentManager fm;
    @BindView(R.id.main_tabs_container)
    LinearLayout tabContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        initTabs();
        presenter = new MainPresenter(fm,fragments,ct);
        presenter.switchTabs(0);//第一个默认选中
    }
    private Fragment[] fragments;
    private CheckedTextView[] ct;
    /**
     * 初始化底部Tab**/
    private void initTabs() {
        fragments = new Fragment[]{new FoodBookFragment(),new FoodClassFragment(),new SheQuFragment(),new OwnerFragment()};
        ct = new CheckedTextView[tabContainer.getChildCount()];
        for (int i = 0; i < tabContainer.getChildCount(); i++) {
            ct[i] = (CheckedTextView) tabContainer.getChildAt(i);
            ct[i].setOnClickListener(this);
        }
    }

    @Override
    public void switchTab(int i) {
        presenter.switchTabs(i);
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < tabContainer.getChildCount(); i++) {
            if(v == ct[i]){
                switchTab(i);
                break;
            }
        }
    }
}
