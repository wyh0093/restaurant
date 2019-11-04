package com.example.restaurant.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-29 16:44
 **/
public class TestD {

    public TestC getC() {
        return c;
    }
    @Autowired
    public void setC(TestC c) {
        this.c = c;
    }

    private TestC c;

    public static void main(String[] args) {
        TestC c = new TestC();
        c.cc();
    }

}
