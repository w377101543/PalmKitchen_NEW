package com.gold.palm.palmkitchen_new.presenter.foodassortment;

import android.support.v4.app.Fragment;

import com.gold.palm.palmkitchen_new.bean.AssortmentBean;
import com.gold.palm.palmkitchen_new.model.foodassortment.AssortmentModel;
import com.gold.palm.palmkitchen_new.model.foodassortment.IAssortmentModel;
import com.gold.palm.palmkitchen_new.model.foodassortment.OnAssortmentListener;
import com.gold.palm.palmkitchen_new.utils.AppUtils;
import com.gold.palm.palmkitchen_new.view.view.IAssortmentView;

/**
 * Created by Wang on 2016/11/2.
 */

public class AssortmentPresenter implements IAssortmentPresenter {
    private IAssortmentModel model;
    private IAssortmentView view;
    private Fragment fragment;
    public AssortmentPresenter(IAssortmentView view,Fragment fragment) {
        this.view = view;
        this.fragment = fragment;
        model = new AssortmentModel(fragment.getContext());
    }

    @Override
    public void getData() {
        view.showLoading();
        if(AppUtils.isNetworkConnected(fragment.getContext())){
            model.getNetWorkData(new OnAssortmentListener() {
                @Override
                public void onSuccess(AssortmentBean bean) {
                    view.setAdapter(bean);
                    view.stopLoading();
                }

                @Override
                public void onFailed() {
                    view.stopLoading();
                    AssortmentBean bean = model.getLocalData();
                    if(bean != null){
                        view.setAdapter(bean);
                    }
                }
            });
        }else {
            AssortmentBean bean = model.getLocalData();
            if(bean != null){
                view.setAdapter(bean);
            }
        }
    }
}
