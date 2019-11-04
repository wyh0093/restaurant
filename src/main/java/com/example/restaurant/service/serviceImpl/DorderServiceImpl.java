package com.example.restaurant.service.serviceImpl;

import com.example.restaurant.entity.Dtype;
import com.example.restaurant.entity.Order;
import com.example.restaurant.repository.DorderReposity;
import com.example.restaurant.service.DorderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 14:59
 **/
@Service
public class DorderServiceImpl implements DorderService {

    @Autowired
    private DorderReposity dorderReposity;
    @Override
    public void save(Order order) {
        dorderReposity.save(order);
    }

    @Override
    public Order findById(int id) {
        return dorderReposity.findById(id).get();
    }

    @Override
    public Page<Order> findAll(PageRequest pageable) {
        return dorderReposity.findAll(pageable);
    }


//    private Specification<Dtype> createFilter(String keyword) {
//        List<Predicate> predicates = new ArrayList<>();
//        return new Specification<Dtype>() {
//            @Override
//            public Predicate toPredicate(Root<Dtype> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> predicates = new ArrayList<>();
//                Predicate[] p = new Predicate[predicates.size()];
//
//                return cb.and(predicates.toArray(p));
//            }
//        };
//    }


}
