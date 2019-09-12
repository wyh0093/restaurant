package com.example.restaurant.service;

import com.example.restaurant.entity.Desk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 18:35
 **/

public interface DeskService {

    Desk findOne(Integer id);

    void save(Desk desk);

    void update(Desk desk);

    Page<Desk> findAll(String keyword, PageRequest pageable);

    void del(Desk desk);
}
