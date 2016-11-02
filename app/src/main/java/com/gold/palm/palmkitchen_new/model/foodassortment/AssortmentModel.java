package com.gold.palm.palmkitchen_new.model.foodassortment;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.AssortmentBean;
import com.gold.palm.palmkitchen_new.utils.FileUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/2.
 */

public class AssortmentModel implements IAssortmentModel {
    private Context context;

    public AssortmentModel(Context context) {
        this.context = context;
    }

    @Override
    public void getNetWorkData(final OnAssortmentListener l) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams(Constants.FOOD_ASSORTMENT_K1,Constants.FOOD_ASSORTMENT_V1)
                .addParams(Constants.FOOD_ASSORTMENT_K2,Constants.FOOD_ASSORTMENT_V2)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                l.onFailed();
            }

            @Override
            public void onResponse(String response, int id) {
                AssortmentBean bean = JSON.parseObject(response, AssortmentBean.class);
                l.onSuccess(bean);
                FileUtils.saveJsonBean(context,response,"assortment_bean");
            }
        });
    }

    @Override
    public AssortmentBean getLocalData() {
        AssortmentBean bean = (AssortmentBean) FileUtils.getLocalBean(context, "assortment_bean");
        return bean;
    }
}
