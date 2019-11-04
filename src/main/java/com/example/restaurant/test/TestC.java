package com.example.restaurant.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-29 16:44
 **/
public class TestC {

    @Autowired
    private TestB b;

    public void cc (){
        this.b.aa();
    }
}
