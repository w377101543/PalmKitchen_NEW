package com.gold.palm.palmkitchen_new.presenter.health;

/**
 * Created by Wang on 2016/11/5.
 */

public interface IHealthPresenter {
    void showLoading();
    void hideLoading();
    void getData1();
    void getData2();
    void loadMore();
    int getTotalCount();
}
