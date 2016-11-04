package com.gold.palm.palmkitchen_new.model.searchlist;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.SearchListBean;
import com.gold.palm.palmkitchen_new.model.foodingredient.*;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/3.
 */

public class SearchListModel implements ISearchListModel{
    @Override
    public void getData(int page, String keyword, final OnGetDataListener l) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams("page",String.valueOf(page))
                .addParams("methodName","SearchDishes")
                .addParams("size","20")
                .addParams("keyword",keyword)
                .addParams("version","4.40").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        l.failed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        SearchListBean bean = JSON.parseObject(response, SearchListBean.class);
                        l.success(bean);
                    }
                });
    }
}
