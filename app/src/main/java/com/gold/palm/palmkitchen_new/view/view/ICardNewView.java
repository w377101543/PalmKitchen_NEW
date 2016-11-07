package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.NewBean;

/**
 * Created by Wang on 2016/11/7.
 */

public interface ICardNewView {
    void showLoading();
    void hideLoading();
    void setAdapter(NewBean bean);
    void notifyData(NewBean bean);
    void loadMoreComplete();
    void refreshComplete();
    void resetData(NewBean bean);
    void noMoreData();
}
