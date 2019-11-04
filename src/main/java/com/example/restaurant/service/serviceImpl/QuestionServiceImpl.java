package com.example.restaurant.service.serviceImpl;

import com.example.restaurant.entity.Question;
import com.example.restaurant.repository.QuestionRepository;
import com.example.restaurant.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-23 10:24
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }
}
