package com.gold.palm.palmkitchen_new.model.search;

import com.gold.palm.palmkitchen_new.bean.SoftSearchBean;

/**
 * Created by Wang on 2016/11/2.
 */

public interface OnSearchListener {
    void onSuccess(SoftSearchBean bean);
    void onFailed();
}
