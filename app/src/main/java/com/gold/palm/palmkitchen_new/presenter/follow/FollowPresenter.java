package com.gold.palm.palmkitchen_new.presenter.follow;

import android.util.Log;
import android.widget.Toast;

import com.gold.palm.palmkitchen_new.bean.FollowBean;
import com.gold.palm.palmkitchen_new.model.follow.FollowModel;
import com.gold.palm.palmkitchen_new.model.follow.OnFinishListener;
import com.gold.palm.palmkitchen_new.presenter.foodrecommend.IFoodRecommendPresenter;
import com.gold.palm.palmkitchen_new.view.view.IFollowView;

/**
 * Created by Wang on 2016/11/6.
 */

public class FollowPresenter implements IFollowPresenter {
    private FollowModel model;
    private IFollowView view;
    private int page = 1;
    private int loadedCount;
    public FollowPresenter(IFollowView view) {
        this.view = view;
        model = new FollowModel();
    }

    @Override
    public void getData() {
        view.showLoading();
        model.getData(page, new OnFinishListener() {
            @Override
            public void onSuccess(FollowBean bean) {
                view.setAdapter(bean);
                view.hideLoading();
                page++;
                loadedCount = bean.getData().getCount();
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
            public void onSuccess(FollowBean bean) {
                view.notifyData(bean);
                page++;
                view.loadMoreComplete();
                loadedCount += bean.getData().getCount();
                if(loadedCount >= bean.getData().getTotal()){
                    view.noMoreData();
                }
            }

            @Override
            public void onFailed() {
                view.loadMoreComplete();
            }
        });
    }

    @Override
    public int getTotalCount() {
        return model.getTotalCount();
    }

    @Override
    public void refresh() {
        page = 1;
        model.getData(page, new OnFinishListener() {
            @Override
            public void onSuccess(FollowBean bean) {
                view.resetData(bean);
                page++;
                view.refreshComplete();
            }

            @Override
            public void onFailed() {
                view.refreshComplete();
            }
        });
    }
}
