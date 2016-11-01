package com.gold.palm.palmkitchen_new.presenter.foodingredient;

import android.content.Context;

import com.gold.palm.palmkitchen_new.bean.IngredientBean;
import com.gold.palm.palmkitchen_new.model.foodingredient.IngredientModel;
import com.gold.palm.palmkitchen_new.model.foodingredient.OnGetDataListener;
import com.gold.palm.palmkitchen_new.view.view.IIngredientView;

/**
 * Created by Wang on 2016/11/1.
 */

public class IngredientPresenter implements IIngredientPresenter {
    private IngredientModel model;
    private IIngredientView view;
    private Context context;
    public IngredientPresenter(IIngredientView view,Context context) {
        this.view = view;
        this.context = context;
        model = new IngredientModel(context);
    }

    @Override
    public void getData() {
        view.showLoading();
        model.getNetWorkData(new OnGetDataListener() {
            @Override
            public void onGetDataSuccess(IngredientBean bean) {
                view.setAdapter(bean);
                view.stopLoading();
            }

            @Override
            public void onGetDataFailed() {
                view.stopLoading();
            }
        });
    }
}
