package com.example.restaurant.service;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dtype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 15:00
 **/
public interface DtypeService {

    Page<Dtype> findAll(String keyword, PageRequest pageable);

    Dtype findOne(Integer id);

    void save(Dtype dtype);

    void del(Dtype dtype);

    List<Dtype> findAllData();
}
