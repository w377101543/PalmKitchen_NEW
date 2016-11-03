package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.SoftSearchBean;

import java.util.List;
import java.util.Set;

/**
 * Created by Wang on 2016/11/2.
 */

public interface ISearchView {
    void search(String word);
    void showHistory(List<String> history);
    void setAdapter(SoftSearchBean bean,int num);
    void showNoResult();
    void hideHistory();
    void hideIndex();
    void addHistoryData(List<String> history);
}
