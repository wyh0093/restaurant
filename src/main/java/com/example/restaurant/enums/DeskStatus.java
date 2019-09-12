package com.example.restaurant.enums;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 18:48
 **/
public enum DeskStatus {
    book("预订"),back("退桌");

    DeskStatus(String str){
        this.str=str;
    }

    public String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
