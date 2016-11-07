package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.NominateBean;

/**
 * Created by Wang on 2016/11/7.
 */

public interface INominateView {
    void showLoading();
    void hideLoading();
    void setAdapter(NominateBean bean);
    void notifyData(NominateBean bean);
}
