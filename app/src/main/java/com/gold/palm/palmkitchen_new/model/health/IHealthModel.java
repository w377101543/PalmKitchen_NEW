package com.gold.palm.palmkitchen_new.model.health;

/**
 * Created by Wang on 2016/11/4.
 */

public interface IHealthModel {
    void getData1(OnGetData1Listener listener);
    void getData2(int page,OnGetData2Listener listener);
    int getTotalCount();
}
