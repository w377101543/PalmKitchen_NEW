package com.gold.palm.palmkitchen_new;

/**
 * Created by Wang on 2016/10/29.
 */

public interface Constants {
    int WELCOME_ACTIVITY_DELAY_WHAT = 0;
    int WELCOME_ACTIVITY_DELAY_TIME = 2000;
    String HOST = "http://api.izhangchu.com";
    String HEALTH_1 = "http://javaapi.izhangchu.com:8084/zcmessage/api/lifeCourseSeries/CourseLogo?&page=1&size=20&user_id=0&token=0&appVersion=4.5&sysVersion=8.4.1&devModel=iPod%20touch&version_app=4.5&package=com.jinbanwen.zcIphone&version=4.5";
    String HEALTH_2 = "http://javaapi.izhangchu.com:8084/zcmessage/api/lifeCourseSeries/CourseIndex?&page={0}&size=10&user_id=0&token=0&appVersion=4.5&sysVersion=8.4.1&devModel=iPod%20touch&version_app=4.5&package=com.jinbanwen.zcIphone&version=4.5";
    String FOOD_RECOMMEND_K1 = "methodName";//methodName=SceneHome&version=4.40
    String FOOD_RECOMMEND_K2 = "version";
    String FOOD_RECOMMEND_V1 = "SceneHome";
    String FOOD_RECOMMEND_V2 = "4.40";

    String FOOD_INGREDIENT_K1 = "methodName";
    String FOOD_INGREDIENT_K2 = "version";
    String FOOD_INGREDIENT_V1 = "MaterialSubtype";
    String FOOD_INGREDIENT_V2 = "4.40";

    String FOOD_ASSORTMENT_K1 = "methodName";
    String FOOD_ASSORTMENT_K2 = "version";
    String FOOD_ASSORTMENT_V1 = "CategoryIndex";
    String FOOD_ASSORTMENT_V2 = "4.40";

    //softSearch
    String SEARCH_K1 = "methodName";
    String SEARCH_K2 = "keyword";
    String SEARCH_K3 = "version";
    String SEARCH_V1 = "SearchKeyword";
    String SEARCH_V3 = "4.40";

    String METHOD_NAME = "methodName";
    String SEARCH_HOT = "SearchHot";
    String VERSION_NAME = "version";
    String VERSION = "4.40";
}
