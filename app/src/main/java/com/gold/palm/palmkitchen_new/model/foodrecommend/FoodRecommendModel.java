package com.gold.palm.palmkitchen_new.model.foodrecommend;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.HomeBean;
import com.gold.palm.palmkitchen_new.utils.FileUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import okhttp3.Call;

/**
 * Created by Wang on 2016/10/30.
 */

public class FoodRecommendModel implements IFoodRecommend {
    private HomeBean homeBean;
    private Context context;
    public FoodRecommendModel(Context context) {
        this.context = context;
    }

    @Override
    public void getData(final OnFoodRecommendListener listener) {
        OkHttpUtils.post().url(Constants.HOST).addParams(Constants.FOOD_RECOMMEND_K1, Constants.FOOD_RECOMMEND_V1)
                .addParams(Constants.FOOD_RECOMMEND_K2, Constants.FOOD_RECOMMEND_V2)
                .tag(this).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.onFailed();
            }

            @Override
            public void onResponse(String response, int id) {
                homeBean = JSON.parseObject(response,HomeBean.class);
                listener.onSuccess(homeBean);
                saveBean(response);
            }
        });
    }

    @Override
    public HomeBean getLocalData() {
        Log.e("TT","开始读取本地数据");
       homeBean = (HomeBean) FileUtils.getLocalBean(context,"home_bean");
        return homeBean;
    }

    private void saveBean(String response) {
        FileUtils.saveJsonBean(context,response,"home_bean");
    }
}
