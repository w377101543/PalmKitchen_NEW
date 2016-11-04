package com.gold.palm.palmkitchen_new.presenter.searchlist;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.gold.palm.palmkitchen_new.bean.SearchListBean;
import com.gold.palm.palmkitchen_new.model.searchlist.OnGetDataListener;
import com.gold.palm.palmkitchen_new.model.searchlist.SearchListModel;
import com.gold.palm.palmkitchen_new.view.view.ISearchListView;

/**
 * Created by Wang on 2016/11/3.
 */

public class SearchListPresenter implements ISearchListPresenter {
    private SearchListModel model;
    private ISearchListView view;
    public SearchListPresenter(ISearchListView view) {
        this.view = view;
        this.model = new SearchListModel();
    }
    private int page = 1;
    private int totalCount;
    private int loadedCount;
    @Override
    public void getData(String keyword) {
        view.showLoading();
        model.getData(page, keyword, new OnGetDataListener() {
            @Override
            public void success(SearchListBean bean) {
                view.setAdapter(bean);
                view.hideLoading();
                page++;
                totalCount = Integer.parseInt(bean.getData().getTotal());
                loadedCount += Integer.parseInt(bean.getData().getCount());
            }

            @Override
            public void failed() {
                view.hideLoading();
            }
        });
    }

    @Override
    public void loadMore(String keyword) {
        model.getData(page, keyword, new OnGetDataListener() {
            @Override
            public void success(SearchListBean bean) {
                view.notifyData(bean);
                view.loadMoreComplete();
                page++;
                loadedCount += Integer.parseInt(bean.getData().getCount());
            }

            @Override
            public void failed() {
                view.loadMoreComplete();
            }
        });
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public int getLoadedCount() {
        return loadedCount;
    }
}
