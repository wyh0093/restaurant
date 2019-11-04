package com.example.restaurant.entity;

import com.example.restaurant.enums.QuestionType;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-23 10:05
 **/
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public QuestionType questionType;
    @Transient
    public String questionTypeStr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTypeStr() {
        return questionTypeStr;
    }

    public void setQuestionTypeStr(String questionTypeStr) {
        this.questionTypeStr = questionTypeStr;
    }
}
