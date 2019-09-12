package com.example.restaurant.util;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 18:19
 **/
public class JsonUtil {

    /**
     * 将object转换成json
     * @param object
     * @return
     */
    public static String parseJsonStr(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }


}
