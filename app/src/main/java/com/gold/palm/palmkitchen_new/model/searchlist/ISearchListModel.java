package com.gold.palm.palmkitchen_new.model.searchlist;

/**
 * Created by Wang on 2016/11/3.
 */

public interface ISearchListModel {
    void getData(int page,String keyword,OnGetDataListener l);
}
