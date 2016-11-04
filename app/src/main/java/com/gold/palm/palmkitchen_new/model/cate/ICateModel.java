package com.gold.palm.palmkitchen_new.model.cate;

/**
 * Created by Wang on 2016/11/4.
 */

public interface ICateModel {
    void getData1(OnGetCateListener1 listener);
    void getData2(String page,OnGetCateListener2 listener);
    int getTotalCount();
}
