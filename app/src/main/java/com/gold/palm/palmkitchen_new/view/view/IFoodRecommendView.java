package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.HomeBean;

/**
 * Created by Wang on 2016/10/29.
 */

public interface IFoodRecommendView {
    void showLoading();
    void stopLoading();
    void getDataSucceed(HomeBean homeBean);
    void getDataFailed();
    void setAdapter();
    void notifyData(HomeBean homeBean);
}
