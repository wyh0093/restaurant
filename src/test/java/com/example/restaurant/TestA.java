package com.example.restaurant;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 13:39
 **/
public class TestA {

    @Value("${img.path}")
    private static String imgPath;

    public static void main(String[] args) {

//        System.out.println(imgPath);
        String path2 = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static";
        System.out.println(path2);
    }


    public void zaoData(){
        StringBuilder str = new StringBuilder();
        str.append("{\"index\":{\"_id\":\"1\"}}\n");
        str.append("{");
        str.append("\"RECORDER\":\"dd\",\"SEVERITY\":\"都是\",\"NAME\":\"ds\",\"DESC\":\"cds\",\"TIME\":\"2019-08-20 10:26:32\",\"D_IP\":\"175.213.235\",\"D_PORT\",8080,");
        str.append("");
        str.append("}");
    }
}
