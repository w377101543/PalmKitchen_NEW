package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.FollowBean;

/**
 * Created by Wang on 2016/11/6.
 */

public interface IFollowView {
    void showLoading();
    void hideLoading();
    void setAdapter(FollowBean bean);
    void notifyData(FollowBean bean);
    void loadMoreComplete();
    void refreshComplete();
    void resetData(FollowBean bean);
    void noMoreData();
}
