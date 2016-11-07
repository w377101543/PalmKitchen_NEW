package com.gold.palm.palmkitchen_new.model.nominate;

import com.gold.palm.palmkitchen_new.bean.NominateBean;

/**
 * Created by Wang on 2016/11/7.
 */

public interface OnFinishListener {
    void onSuccess(NominateBean bean);
    void onFailed();
}
