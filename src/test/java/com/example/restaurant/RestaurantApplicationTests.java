package com.example.restaurant;

import com.example.restaurant.entity.Question;
import com.example.restaurant.enums.QuestionType;
import com.example.restaurant.repository.QuestionRepository;
import com.example.restaurant.test.EsClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.UnknownHostException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantApplicationTests {

    /** Logger实例 */
    static final Logger logger = LoggerFactory.getLogger(RestaurantApplicationTests.class);


    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private EsClient esClient;
    @Test
    public void contextLoads() {

        Question question = new Question();
        question.setName("市场调研");
        question.setQuestionType(QuestionType.subject);
//        question.setQuestionTypeStr(QuestionType.subject.qtype);
        questionRepository.save(question);
    }
    @Test
    public void getQuestionById(){
        Question question = questionRepository.findById(1).get();
        question.setQuestionTypeStr(question.getQuestionType().getQtype());
        System.out.println(question.getQuestionTypeStr());
    }
    @Test
    public void getEsClient(){
        try {
            esClient.getClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getLog(){
        logger.info("33333333");
        logger.error("4444444444444!");
    }

}
