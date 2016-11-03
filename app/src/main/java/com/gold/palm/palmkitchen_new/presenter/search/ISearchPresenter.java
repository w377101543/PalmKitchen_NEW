package com.gold.palm.palmkitchen_new.presenter.search;

import android.content.Context;

import java.util.List;
import java.util.Set;

/**
 * Created by Wang on 2016/11/2.
 */

public interface ISearchPresenter {
    void getKeywordData(String keyword);
    void getHistory();
    List<String> getHotSearch(Context context);
    void search(String keyword);
}
