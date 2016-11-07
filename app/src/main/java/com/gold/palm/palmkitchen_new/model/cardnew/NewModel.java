package com.gold.palm.palmkitchen_new.model.cardnew;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.NewBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/7.
 */

public class NewModel implements INewModel {
    private int totalCount;
    @Override
    public void getData(int page, final OnFinishListener listener) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams("is_marrow","0")
                .addParams("page",page+"")
                .addParams("methodName","ShequList")
                .addParams("last_id","0")
                .addParams("size","20")
                .addParams("version","20").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        NewBean bean = JSON.parseObject(response, NewBean.class);
                        totalCount = bean.getData().getTotal();
                        listener.onSuccess(bean);
                    }
                });
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }
}
