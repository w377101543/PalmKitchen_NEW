package com.gold.palm.palmkitchen_new.model.foodassortment;

import com.gold.palm.palmkitchen_new.bean.AssortmentBean;

/**
 * Created by Wang on 2016/11/2.
 */

public interface IAssortmentModel {
    void getNetWorkData(OnAssortmentListener l);
    AssortmentBean getLocalData();
}
