package com.gold.palm.palmkitchen_new.model.foodingredient;

import com.gold.palm.palmkitchen_new.bean.IngredientBean;

/**
 * Created by Wang on 2016/11/1.
 */

public interface OnGetDataListener {
    void onGetDataSuccess(IngredientBean bean);
    void onGetDataFailed();
}
