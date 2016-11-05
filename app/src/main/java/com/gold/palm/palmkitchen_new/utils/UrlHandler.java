package com.gold.palm.palmkitchen_new.utils;

/**
 * Created by Wang on 2016/11/5.
 */

public class UrlHandler {
    public static String handle(String url,Object...params){
        for (int i = 0; i < params.length; i++) {
            url = url.replace("{" + i + "}", params[i] + "");
        }
        return  url;
    }
}
