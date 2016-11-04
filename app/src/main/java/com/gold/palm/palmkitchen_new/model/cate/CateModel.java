package com.gold.palm.palmkitchen_new.model.cate;

import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.CateBean1;
import com.gold.palm.palmkitchen_new.bean.CateBean2;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/4.
 */

public class CateModel implements ICateModel {
    private int totalCount;
    @Override
    public void getData1(final OnGetCateListener1 listener) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams("methodName","CourseLogo")
                .addParams("version","4.40").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        CateBean1 bean1 = JSON.parseObject(response, CateBean1.class);
                        listener.onSuccess(bean1);
                    }
                });
    }
    public void getData2(String page, final OnGetCateListener2 listener){
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams("methodName","CourseIndex")
                .addParams("page",page)
                .addParams("size","20")
                .addParams("version","4.40").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailed();
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        CateBean2 bean2 = JSON.parseObject(response, CateBean2.class);
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
