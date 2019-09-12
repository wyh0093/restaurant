package com.example.restaurant.util;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 13:53
 **/
public class GetPath {

    public static String getClassPath(){
        String path = "";
        try {
            path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);
            String path2 = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }
}
