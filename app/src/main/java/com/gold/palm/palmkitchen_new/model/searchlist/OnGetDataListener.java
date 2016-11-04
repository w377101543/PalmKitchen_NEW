package com.gold.palm.palmkitchen_new.model.searchlist;

import com.gold.palm.palmkitchen_new.bean.SearchListBean;

/**
 * Created by Wang on 2016/11/3.
 */

public interface OnGetDataListener {
    void success(SearchListBean bean);
    void failed();
}
