package com.gold.palm.palmkitchen_new.model.foodingredient;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.gold.palm.palmkitchen_new.Constants;
import com.gold.palm.palmkitchen_new.bean.IngredientBean;
import com.gold.palm.palmkitchen_new.utils.FileUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Wang on 2016/11/1.
 */

public class IngredientModel implements IIngredientModel {
    private Context context;

    public IngredientModel(Context context) {
        this.context = context;
    }

    @Override
    public void getNetWorkData(final OnGetDataListener l) {
        OkHttpUtils.post().url(Constants.HOST)
                .addParams(Constants.FOOD_INGREDIENT_K1,Constants.FOOD_INGREDIENT_V1)
                .addParams(Constants.FOOD_INGREDIENT_K2,Constants.FOOD_INGREDIENT_V2)
                .tag(this).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                l.onGetDataFailed();
            }

            @Override
            public void onResponse(String response, int id) {
                IngredientBean bean = JSON.parseObject(response, IngredientBean.class);
                l.onGetDataSuccess(bean);
                FileUtils.saveJsonBean(context,response,"ingredient_bean");
            }
        });
    }
}
