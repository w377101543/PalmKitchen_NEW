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
