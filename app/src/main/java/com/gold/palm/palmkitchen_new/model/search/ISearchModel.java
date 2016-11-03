package com.gold.palm.palmkitchen_new.model.search;

import android.content.Context;

import java.util.List;
import java.util.Set;

/**
 * Created by Wang on 2016/11/2.
 */

public interface ISearchModel {
    void getData(String keyword,OnSearchListener l);
    void saveHistory(Context context, String keyword);
    List<String> getHistory(Context context);
    List<String> getNetHot(Context context);
}
