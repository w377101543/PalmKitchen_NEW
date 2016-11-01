package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.IngredientBean;

/**
 * Created by Wang on 2016/11/1.
 */

public interface IIngredientView {
    void setAdapter(IngredientBean bean);
    void showLoading();
    void stopLoading();
}
