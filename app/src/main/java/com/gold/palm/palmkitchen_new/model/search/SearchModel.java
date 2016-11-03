package com.gold.palm.palmkitchen_new.model.search;

import android.content.Context;
import android.content.SharedPreferences;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.SoftSearchBean;
import com.gold.palm.palmkitchen_new.utils.FileUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/2.
 */

public class SearchModel implements ISearchModel {
    @Override
    public void getData(String keyword, final OnSearchListener l) {
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams(Constants.SEARCH_K1,Constants.SEARCH_V1)
                .addParams(Constants.SEARCH_K2,keyword)
                .addParams(Constants.SEARCH_K3,Constants.SEARCH_V3)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                l.onFailed();
            }

            @Override
            public void onResponse(String response, int id) {
                SoftSearchBean bean = JSON.parseObject(response, SoftSearchBean.class);
                l.onSuccess(bean);
            }
        });
    }

    @Override
    public void saveHistory(Context context,String keyword) {
        FileUtils.saveSearchKeyword(context,keyword);
    }

    @Override
    public List<String> getHistory(Context context) {
        return FileUtils.getSearchHistory(context);
    }

    @Override
    public List<String> getNetHot(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("hot_search", Context.MODE_PRIVATE);
        String hotValue = preferences.getString("hot",null);
        List<String> list = JSON.parseArray(hotValue,String.class);
        return list;
    }
}
