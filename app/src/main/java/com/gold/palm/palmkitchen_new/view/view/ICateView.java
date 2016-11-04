package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.CateBean1;
import com.gold.palm.palmkitchen_new.bean.CateBean2;

/**
 * Created by Wang on 2016/11/4.
 */

public interface ICateView {
    void showLoading();
    void hideLoading();
    void setAdapter1(CateBean1 bean1);
    void setAdapter2(CateBean2 bean2);
    void notifyData(CateBean2 bean2);
    void loadMoreComplete();
    void setNoMoreData();
}
