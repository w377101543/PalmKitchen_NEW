package com.gold.palm.palmkitchen_new.view.view;

import com.gold.palm.palmkitchen_new.bean.AssortmentBean;

/**
 * Created by Wang on 2016/11/2.
 */

public interface IAssortmentView {
    void  showLoading();
    void stopLoading();
    void setAdapter(AssortmentBean bean);

}
