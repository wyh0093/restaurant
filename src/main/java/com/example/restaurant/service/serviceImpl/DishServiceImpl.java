package com.example.restaurant.service.serviceImpl;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dish;
import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.service.DishService;
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
 * @create: 2019-08-08 14:04
 **/
@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;
    @Override
    public Page<Dish> findAll(String keyword,int dTypeId, PageRequest pageable) {
        Page<Dish> all = this.dishRepository.findAll(createFilter(keyword,dTypeId),pageable);
        return all;
    }

    private Specification<Dish> createFilter(String keyword,int dTypeId) {
        List<Predicate> predicates = new ArrayList<>();
        return new Specification<Dish>() {
            @Override
            public Predicate toPredicate(Root<Dish> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(keyword)){
                    Predicate id = cb.like(root.get("id").as(String.class), "%" + keyword + "%");
                    Predicate name = cb.like(root.get("d_name").as(String.class), "%" + keyword + "%");
                    predicates.add(cb.or(id, name));
                }
                if(dTypeId!=0){
                    Predicate dtypeId = cb.equal(root.get("d_typeId").as(Integer.class),dTypeId);
                    predicates.add(cb.and(dtypeId));
                }
                Predicate[] p = new Predicate[predicates.size()];

                return cb.and(predicates.toArray(p));
            }
        };
    }

    @Override
    public Dish findOne(Integer id) {
        return dishRepository.findById(id).get();
    }

    @Override
    public void save(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void update(Dish dish) {

    }

    @Override
    public void del(Dish dish) {
        dishRepository.delete(dish);
    }
}
