package com.gold.palm.palmkitchen_new.presenter.foodrecommend;

/**
 * Created by Wang on 2016/10/30.
 */

public interface IFoodRecommendPresenter {
    void getNetWorkData(int tag);
    void startLoading();
    void stopLoading();
    void getLocalData();
    void getData();

}
