package com.example.restaurant.repository;

import com.example.restaurant.entity.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 18:33
 **/
public interface DeskRepository extends JpaRepository<Desk, Integer>
        , JpaSpecificationExecutor<Desk> {

    Optional<Desk> findById(Integer integer);
}
