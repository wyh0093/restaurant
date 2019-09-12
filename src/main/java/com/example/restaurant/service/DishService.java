package com.example.restaurant.service;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 14:03
 **/
public interface DishService {

    Page<Dish> findAll(String keyword, int dTypeId,PageRequest pageable);

    Dish findOne(Integer id);

    void save(Dish dish);

    void update(Dish Dish);

    void del(Dish Dish);
}
