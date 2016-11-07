package com.gold.palm.palmkitchen_new.model.cardnew;

/**
 * Created by Wang on 2016/11/7.
 */

public interface INewModel {
    void getData(int page,OnFinishListener listener);
    int getTotalCount();
}
