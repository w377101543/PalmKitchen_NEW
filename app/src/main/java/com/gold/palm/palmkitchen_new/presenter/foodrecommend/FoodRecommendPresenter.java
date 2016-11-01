package com.gold.palm.palmkitchen_new.presenter.foodrecommend;

import android.content.Context;
import android.util.Log;

import com.gold.palm.palmkitchen_new.bean.HomeBean;
import com.gold.palm.palmkitchen_new.model.foodrecommend.FoodRecommendModel;
import com.gold.palm.palmkitchen_new.model.foodrecommend.OnFoodRecommendListener;
import com.gold.palm.palmkitchen_new.view.view.IFoodRecommendView;

/**
 * Created by Wang on 2016/10/30.
 */

public class FoodRecommendPresenter implements IFoodRecommendPresenter {
    private FoodRecommendModel model;
    private IFoodRecommendView view;
    public FoodRecommendPresenter(IFoodRecommendView view, Context context) {
        this.view = view;
        model = new FoodRecommendModel(context);
    }

    @Override
    public void getNetWorkData(final int tag) {
        if(tag == 0){
            startLoading();
        }
        model.getData(new OnFoodRecommendListener() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                view.getDataSucceed(homeBean);
                if(tag == 0){
                    view.setAdapter();
                }else if(tag == 1){
                    view.notifyData(homeBean);
                }
            }

            @Override
            public void onFailed() {
                view.stopLoading();
                view.getDataFailed();
            }
        });
    }

    @Override
    public void startLoading() {
        view.showLoading();
    }

    @Override
    public void stopLoading() {
        view.stopLoading();
    }

    @Override
    public void getLocalData() {
        view.showLoading();
        HomeBean homeBean = model.getLocalData();
        if(homeBean!=null){
            view.getDataSucceed(homeBean);
            view.setAdapter();
        }
    }

    @Override
    public void getData() {
        view.showLoading();
        HomeBean homeBean = model.getLocalData();
        Log.e("homeBean",""+homeBean);
        if(homeBean == null){
            getNetWorkData(0);
        }else {
            view.getDataSucceed(homeBean);
            view.setAdapter();
        }
    }
}
