package com.example.restaurant.service;

import com.example.restaurant.entity.Detail;

import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 15:03
 **/
public interface DetailsService {

    void save(Detail detail);

    void deleteById(int id);
    //根据餐桌名称查询未结账的详细订单
    List<Detail> findByDeskName(String deskName);

    int getPricesByDeskName(String deskName);
}
