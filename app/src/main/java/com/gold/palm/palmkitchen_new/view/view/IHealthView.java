package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.HealthBean1;
import com.gold.palm.palmkitchen_new.bean.HealthBean2;

/**
 * Created by Wang on 2016/11/5.
 */

public interface IHealthView {
    void showLoading();
    void hideLoading();
    void setAdapter1(HealthBean1 bean1);
    void setAdapter2(HealthBean2 bean2);
    void loadMoreComplete();
    void notifyData(HealthBean2 bean2);
    void setNoMoreData();
}
