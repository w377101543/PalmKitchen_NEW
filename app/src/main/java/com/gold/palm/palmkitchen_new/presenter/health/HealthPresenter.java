package com.gold.palm.palmkitchen_new.presenter.health;

import android.util.Log;

import com.gold.palm.palmkitchen_new.bean.HealthBean1;
import com.gold.palm.palmkitchen_new.bean.HealthBean2;
import com.gold.palm.palmkitchen_new.model.health.HealthModel;
import com.gold.palm.palmkitchen_new.model.health.OnGetData1Listener;
import com.gold.palm.palmkitchen_new.model.health.OnGetData2Listener;
import com.gold.palm.palmkitchen_new.view.view.IHealthView;

/**
 * Created by Wang on 2016/11/5.
 */

public class HealthPresenter implements IHealthPresenter {
    private IHealthView view;
    private HealthModel model;
    private int page = 1;
    private int count;
    public HealthPresenter(IHealthView view) {
        this.view = view;
        model = new HealthModel();
    }

    @Override
    public void showLoading() {
        view.showLoading();
    }

    @Override
    public void hideLoading() {
        view.hideLoading();
    }

    @Override
    public void getData1() {
        view.showLoading();
        model.getData1(new OnGetData1Listener() {
            @Override
            public void onSuccess(HealthBean1 bean1) {
                view.setAdapter1(bean1);
                view.hideLoading();
            }

            @Override
            public void onFailed() {
                view.hideLoading();
            }
        });
    }

    @Override
    public void getData2() {
        view.showLoading();
        model.getData2(page, new OnGetData2Listener() {
            @Override
            public void onSuccess(HealthBean2 bean2) {
                view.setAdapter2(bean2);
                count+=Integer.parseInt(bean2.getData().getCount());
                page++;
                view.hideLoading();
            }

            @Override
            public void onFailed() {
                view.hideLoading();
            }
        });
    }

    @Override
    public void loadMore() {
        model.getData2(page, new OnGetData2Listener() {
            @Override
            public void onSuccess(HealthBean2 bean2) {
                view.notifyData(bean2);
                count += Integer.parseInt(bean2.getData().getCount());
                view.loadMoreComplete();
                if(count >= model.getTotalCount()){
                    view.setNoMoreData();
                }
                page++;
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public int getTotalCount() {
        return model.getTotalCount();
    }

}
