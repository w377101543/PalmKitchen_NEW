package com.gold.palm.palmkitchen_new.model.main;

import android.content.Context;
import android.content.SharedPreferences;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.HotSearchBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/3.
 */

public class MainModel implements IMainModel {
    @Override
    public void getHotSearch(final Context context) {
        final List<String> list = new ArrayList<>();
        OkHttpUtils.post().url(Constants.HOST).tag(this)
                .addParams(Constants.METHOD_NAME,Constants.SEARCH_HOT)
                .addParams(Constants.VERSION_NAME,Constants.VERSION)
        .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                list.add("鸡腿");
                list.add("排骨汤");
                list.add("鸡肉");
                list.add("川菜");
                list.add("白菜");
                SharedPreferences preferences = context.getSharedPreferences("hot_search",Context.MODE_PRIVATE);
                preferences.edit().putString("hot",JSON.toJSONString(list)).apply();
            }

            @Override
            public void onResponse(String response, int id) {
                HotSearchBean bean = JSON.parseObject(response, HotSearchBean.class);
                List<HotSearchBean.DataOne.DataTwo> data = bean.getData().getData();
                for (int i = 0; i < data.size(); i++) {
                    list.add(0,data.get(i).getText());
                }
                SharedPreferences preferences = context.getSharedPreferences("hot_search",Context.MODE_PRIVATE);
                preferences.edit().putString("hot",JSON.toJSONString(list)).apply();
            }
        });
    }
}
