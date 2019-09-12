package com.example.restaurant.repository;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 12:23
 **/
public interface DishRepository  extends JpaRepository<Dish, Integer>
        , JpaSpecificationExecutor<Dish> {
}
