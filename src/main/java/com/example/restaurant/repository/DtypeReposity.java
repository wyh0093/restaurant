package com.example.restaurant.repository;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dish;
import com.example.restaurant.entity.Dtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 14:40
 **/
public interface DtypeReposity extends JpaRepository<Dtype, Integer>
        , JpaSpecificationExecutor<Dtype> {

    Optional<Dtype> findById(Integer integer);
}
