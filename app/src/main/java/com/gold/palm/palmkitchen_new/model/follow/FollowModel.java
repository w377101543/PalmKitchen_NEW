package com.gold.palm.palmkitchen_new.model.follow;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.FollowBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/6.
 */

public class FollowModel implements IFollowModel {
    private int totalCount;
    @Override
    public void getData(int page, final OnFinishListener listener) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams("page",page+"")
                .addParams("methodName","ShequFollow")
                .addParams("size","20")
                .addParams("version","4.40").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        FollowBean bean = JSON.parseObject(response, FollowBean.class);
                        listener.onSuccess(bean);
                        totalCount = bean.getData().getTotal();
                    }
                });
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }
}
