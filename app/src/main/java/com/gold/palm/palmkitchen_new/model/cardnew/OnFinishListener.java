package com.gold.palm.palmkitchen_new.model.cardnew;

import com.gold.palm.palmkitchen_new.bean.NewBean;

/**
 * Created by Wang on 2016/11/7.
 */

public interface OnFinishListener {
    void onSuccess(NewBean bean);
    void onFailed();
}
