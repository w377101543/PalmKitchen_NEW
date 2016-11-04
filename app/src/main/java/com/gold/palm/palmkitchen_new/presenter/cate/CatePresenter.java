package com.gold.palm.palmkitchen_new.presenter.cate;

import com.gold.palm.palmkitchen_new.bean.CateBean1;
import com.gold.palm.palmkitchen_new.bean.CateBean2;
import com.gold.palm.palmkitchen_new.model.cate.CateModel;
import com.gold.palm.palmkitchen_new.model.cate.OnGetCateListener1;
import com.gold.palm.palmkitchen_new.model.cate.OnGetCateListener2;
import com.gold.palm.palmkitchen_new.view.view.ICateView;

/**
 * Created by Wang on 2016/11/4.
 */

public class CatePresenter implements ICatePresenter {
    private ICateView view;
    private CateModel model;
    private int count;
    public CatePresenter(ICateView view) {
        this.view = view;
        model = new CateModel();
    }
    private int page = 1;
    @Override
    public void getData1() {
        view.showLoading();
        model.getData1(new OnGetCateListener1() {
            @Override
            public void onSuccess(CateBean1 bean1) {
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
        model.getData2(String.valueOf(page), new OnGetCateListener2() {
            @Override
            public void onSuccess(CateBean2 bean2) {
                view.setAdapter2(bean2);
                page++;
                view.hideLoading();
                count+=Integer.parseInt(bean2.getData().getCount());
            }

            @Override
            public void onFailed() {
                view.hideLoading();
            }
        });
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
    public void loadMore() {
        model.getData2(String.valueOf(page), new OnGetCateListener2() {
            @Override
            public void onSuccess(CateBean2 bean2) {
                view.notifyData(bean2);
                page++;
                view.loadMoreComplete();
                count+=Integer.parseInt(bean2.getData().getCount());
                if(count>=model.getTotalCount()){
                    view.setNoMoreData();
                }
            }

            @Override
            public void onFailed() {
                view.loadMoreComplete();
            }
        });
    }
}
