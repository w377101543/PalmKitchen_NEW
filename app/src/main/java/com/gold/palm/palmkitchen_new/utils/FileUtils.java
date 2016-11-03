package com.gold.palm.palmkitchen_new.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gold.palm.palmkitchen_new.bean.HomeBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executors;

/**
 * Created by Wang on 2016/11/1.
 */

public class FileUtils {
    public static void saveJsonBean(final Context context, final String json, final String fileName){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                FileOutputStream fos = null;
                try {
                    fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                    bw.write(json);
                    bw.flush();
                    Log.e("Ts","数据保存成功,"+json);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

    }
    public static Object getLocalBean(Context context,String fileName){
        FileInputStream fis = null;
        Object object = null;
        try {
            fis = context.openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = br.readLine())!=null){
                sb.append(str);
            }
            object = JSON.parseObject(sb.toString(), HomeBean.class);
            Log.e("TT","数据读取成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e("TT","数据读取失败");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("TT","数据读取失败");
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return object;
        }
    }
    public static void saveSearchKeyword(Context context,String keyword){
        SharedPreferences preferences = context.getSharedPreferences("search_history", Context.MODE_PRIVATE);
        Set<String> set = null;
        set = preferences.getStringSet("history", set);
        if(set == null){
            set = new HashSet<>();
        }
        set.add(keyword);
        preferences.edit().putStringSet("history",set).apply();
        Toast.makeText(context,"搜索记录保存成功",Toast.LENGTH_SHORT).show();
    }
    public static Set<String> getSearchHistory(Context context){
        SharedPreferences preferences = context.getSharedPreferences("search_history",Context.MODE_PRIVATE);
        return preferences.getStringSet("history", null);
    }
}
