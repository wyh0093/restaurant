package com.example.restaurant.test;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-29 11:19
 **/
public class TestB extends TestA {
    {
        System.out.println("B...");
    }
    static {
        System.out.println("staticB...");
    }
    TestB(){
        System.out.println("testB...");
    }

    public void aa(){
        System.out.println("asdf...");
    }

    public static void main(String[] args) {
//        TestA a = new TestB();
//        ((TestB) a).aa();

        TestB b = new TestB();
        b.aa();
    }
}

