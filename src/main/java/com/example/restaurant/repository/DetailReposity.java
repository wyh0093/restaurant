package com.example.restaurant.repository;

import com.example.restaurant.entity.Detail;
import com.example.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 15:02
 **/
public interface DetailReposity extends JpaRepository<Detail, Integer>
        , JpaSpecificationExecutor<Detail> {
    @Query("from Detail where deskName =?1 and status='0'")
    List<Detail> findByDeskName(String deskName);
}
