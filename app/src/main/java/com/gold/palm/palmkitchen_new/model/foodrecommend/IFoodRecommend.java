package com.gold.palm.palmkitchen_new.model.foodrecommend;

import com.gold.palm.palmkitchen_new.bean.HomeBean;

/**
 * Created by Wang on 2016/10/30.
 */

public interface IFoodRecommend {
    void getData(OnFoodRecommendListener listener);
    HomeBean getLocalData();
}
