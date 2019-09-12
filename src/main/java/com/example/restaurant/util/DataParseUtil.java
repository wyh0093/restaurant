package com.example.restaurant.util;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 16:06
 **/
public class DataParseUtil {

    public static Double oneDecimal(Double d){
        double d2 = Double.parseDouble(String.format("%.1f", d));
        return d2;
    }
}
