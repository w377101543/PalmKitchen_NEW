package com.gold.palm.palmkitchen_new.presenter.nominate;

import com.gold.palm.palmkitchen_new.bean.NominateBean;
import com.gold.palm.palmkitchen_new.model.nominate.INominateModel;
import com.gold.palm.palmkitchen_new.model.nominate.NominateModel;
import com.gold.palm.palmkitchen_new.model.nominate.OnFinishListener;
import com.gold.palm.palmkitchen_new.view.view.INominateView;

/**
 * Created by Wang on 2016/11/7.
 */

public class NominatePresenter implements INominatePresenter {
    private NominateModel model;
    private INominateView view;

    public NominatePresenter(INominateView view) {
        this.view = view;
        model = new NominateModel();
    }

    @Override
    public void getData() {
        view.showLoading();
        model.getData(new OnFinishListener() {
            @Override
            public void onSuccess(NominateBean bean) {
                view.setAdapter(bean);
                view.hideLoading();
            }

            @Override
            public void onFailed() {
                view.hideLoading();
            }
        });
    }

    @Override
    public void refresh() {
        model.getData(new OnFinishListener() {
            @Override
            public void onSuccess(NominateBean bean) {
                view.notifyData(bean);
            }

            @Override
            public void onFailed() {

            }
        });
    }
}
