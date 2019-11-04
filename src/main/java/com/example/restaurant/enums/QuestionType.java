package com.example.restaurant.enums;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-23 10:43
 **/
public enum QuestionType {

    subject("主观题"),object("客观题");

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String qtype;
    QuestionType(String qtype){this.qtype=qtype;}
}
