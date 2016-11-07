package com.gold.palm.palmkitchen_new.model.nominate;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.NominateBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/7.
 */

public class NominateModel implements INominateModel{

    @Override
    public void getData(final OnFinishListener listener) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams("methodName","ShequRecommend")
                .addParams("version","4.40").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        NominateBean bean = JSON.parseObject(response, NominateBean.class);
                        listener.onSuccess(bean);
                    }
                });
    }
}
