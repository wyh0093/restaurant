package com.example.restaurant.controller;

import com.example.restaurant.entity.Question;
import com.example.restaurant.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-23 10:25
 **/
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @RequestMapping("/save")
    public void save(){
        Question question = new Question();
        question.setName("主观题");
        questionService.save(question);
    }
}
