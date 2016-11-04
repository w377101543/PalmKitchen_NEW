package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.SearchListBean;

/**
 * Created by Wang on 2016/11/3.
 */

public interface ISearchListView {
    void setAdapter(SearchListBean bean);

    void notifyData(SearchListBean bean);
    void showLoading();
    void hideLoading();
    void loadMoreComplete();
}
