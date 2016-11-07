package com.gold.palm.palmkitchen_new.model.follow;

/**
 * Created by Wang on 2016/11/6.
 */

public interface IFollowModel {
    void getData(int page,OnFinishListener listener);
    int getTotalCount();
}
