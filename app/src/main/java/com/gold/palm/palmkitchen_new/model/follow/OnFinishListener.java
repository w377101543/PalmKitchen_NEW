package com.gold.palm.palmkitchen_new.model.follow;

import com.gold.palm.palmkitchen_new.bean.FollowBean;

/**
 * Created by Wang on 2016/11/6.
 */

public interface OnFinishListener {
    void onSuccess(FollowBean bean);
    void onFailed();
}
