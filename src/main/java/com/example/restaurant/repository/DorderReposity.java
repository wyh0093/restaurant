package com.example.restaurant.repository;

import com.example.restaurant.entity.Dtype;
import com.example.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 15:01
 **/
public interface DorderReposity extends JpaRepository<Order, Integer>
        , JpaSpecificationExecutor<Order> {
}
