package com.gold.palm.palmkitchen_new.presenter.cardnew;

import android.util.Log;

import com.gold.palm.palmkitchen_new.bean.NewBean;
import com.gold.palm.palmkitchen_new.model.cardnew.NewModel;
import com.gold.palm.palmkitchen_new.model.cardnew.OnFinishListener;
import com.gold.palm.palmkitchen_new.view.view.ICardNewView;

/**
 * Created by Wang on 2016/11/7.
 */

public class NewPresenter implements INewPresenter{
    private NewModel model;
    private ICardNewView view;
    private int page = 1;
    private int count;
    public NewPresenter(ICardNewView view) {
        model = new NewModel();
        this.view = view;
    }

    @Override
    public void getData() {
        view.showLoading();
        model.getData(page, new OnFinishListener() {
            @Override
            public void onSuccess(NewBean bean) {
                view.setAdapter(bean);
                view.hideLoading();
                page++;
                count+=bean.getData().getCount();
                Log.e("count",count+","+model.getTotalCount());
                if(count >= bean.getData().getTotal()){
                    view.noMoreData();
                }
            }

            @Override
            public void onFailed() {
                view.hideLoading();
            }
        });
    }

    @Override
    public void loadMore() {
        model.getData(page, new OnFinishListener() {
            @Override
            public void onSuccess(NewBean bean) {
                view.notifyData(bean);
                view.loadMoreComplete();
                page++;
                count+=bean.getData().getCount();
                if(count >= bean.getData().getTotal()){
                    view.noMoreData();
                }
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void refresh() {
        page = 1;
        model.getData(page, new OnFinishListener() {
            @Override
            public void onSuccess(NewBean bean) {
                view.resetData(bean);
                page++;
                view.refreshComplete();
                count = bean.getData().getCount();
            }

            @Override
            public void onFailed() {

            }
        });
    }
}
