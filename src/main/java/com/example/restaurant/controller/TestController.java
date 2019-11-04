package com.example.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-09 10:06
 **/
@RestController
public class TestController {

    /** Logger实例 */
    private  Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    public String str(){


        logger.info("www");
        logger.error("22222");
        return "index";
    }
}
