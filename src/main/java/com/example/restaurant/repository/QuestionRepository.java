package com.example.restaurant.repository;

import com.example.restaurant.entity.Dtype;
import com.example.restaurant.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-23 10:22
 **/
public interface QuestionRepository extends JpaRepository<Question, Integer>
        , JpaSpecificationExecutor<Question> {

}
