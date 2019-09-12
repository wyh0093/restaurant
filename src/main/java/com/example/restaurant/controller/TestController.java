package com.example.restaurant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-09 10:06
 **/
//@RestController
public class TestController {
    @RequestMapping("/")
    public String str(){
        return "index";
    }
}
