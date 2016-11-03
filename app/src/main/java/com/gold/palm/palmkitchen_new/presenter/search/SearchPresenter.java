package com.gold.palm.palmkitchen_new.presenter.search;

import android.content.Context;

import com.gold.palm.palmkitchen_new.bean.SoftSearchBean;
import com.gold.palm.palmkitchen_new.model.search.OnSearchListener;
import com.gold.palm.palmkitchen_new.model.search.SearchModel;
import com.gold.palm.palmkitchen_new.view.view.ISearchView;

import java.util.List;
import java.util.Set;

/**
 * Created by Wang on 2016/11/2.
 */

public class SearchPresenter implements ISearchPresenter {
    private ISearchView view;
    private SearchModel model;
    private Context context;

    public SearchPresenter(Context context, ISearchView view) {
        this.view = view;
        this.context = context;
        model = new SearchModel();
    }

    @Override
    public void getKeywordData(String keyword) {
        model.getData(keyword, new OnSearchListener() {
            @Override
            public void onSuccess(SoftSearchBean bean) {
                if (bean.getData().getData().size() != 0) {
                    view.setAdapter(bean, bean.getData().getData().size());
                    return;
                }
                view.showNoResult();
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void getHistory() {
        List<String> history = model.getHistory(context);
        if (history != null) {
            view.showHistory(history);
            return;
        }
        view.hideHistory();
    }

    @Override
    public List<String> getHotSearch(Context context) {
        return model.getNetHot(context);
    }

    @Override
    public void search(String keyword) {
        model.saveHistory(context,keyword);
    }
}
