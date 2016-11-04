package com.gold.palm.palmkitchen_new.presenter.searchlist;

/**
 * Created by Wang on 2016/11/3.
 */

public interface ISearchListPresenter {
    void getData(String keyword);
    void loadMore(String keyword);
    int getTotalCount();
    int getLoadedCount();
}
