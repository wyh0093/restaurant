package com.example.restaurant.service;

import com.example.restaurant.entity.Dtype;
import com.example.restaurant.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 14:57
 **/
public interface DorderService {

    void save(Order order);

    Order findById(int id);

    Page<Order> findAll(PageRequest pageable);
}
