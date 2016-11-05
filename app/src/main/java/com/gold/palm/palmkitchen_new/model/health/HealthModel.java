package com.gold.palm.palmkitchen_new.model.health;

import android.graphics.pdf.PdfDocument;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.HealthBean1;
import com.gold.palm.palmkitchen_new.bean.HealthBean2;
import com.gold.palm.palmkitchen_new.utils.UrlHandler;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/4.
 */

public class HealthModel implements IHealthModel {
    private int totalCount;
    @Override
    public void getData1(final OnGetData1Listener listener) {
        OkHttpUtils.get().url(Constants.HEALTH_1).tag(this).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        HealthBean1 bean1 = JSON.parseObject(response, HealthBean1.class);
                        listener.onSuccess(bean1);
                    }
                });
    }

    @Override
    public void getData2(int page,final OnGetData2Listener listener) {
        OkHttpUtils.get().url(UrlHandler.handle(Constants.HEALTH_2, page)).tag(this).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        HealthBean2 bean2 = JSON.parseObject(response, HealthBean2.class);
                        totalCount = Integer.parseInt(bean2.getData().getTotal());
                        listener.onSuccess(bean2);
                    }
                });
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }
}
