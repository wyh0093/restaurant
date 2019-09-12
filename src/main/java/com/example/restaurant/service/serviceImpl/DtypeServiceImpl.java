package com.example.restaurant.service.serviceImpl;

import com.example.restaurant.entity.Dish;
import com.example.restaurant.entity.Dtype;
import com.example.restaurant.repository.DtypeReposity;
import com.example.restaurant.service.DtypeService;
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
 * @create: 2019-08-08 15:01
 **/
@Service
public class DtypeServiceImpl implements DtypeService {

    @Autowired
    private DtypeReposity  dtypeReposity;
    @Override
    public Page<Dtype> findAll(String keyword, PageRequest pageable) {
        return dtypeReposity.findAll(createFilter(keyword),pageable);
    }
    @Override
    public List<Dtype> findAllData(){
        return dtypeReposity.findAll();
    }
    @Override
    public Dtype findOne(Integer id) {
        return dtypeReposity.findById(id).get();
    }

    @Override
    public void save(Dtype dtype) {
        dtypeReposity.save(dtype);
    }

    @Override
    public void del(Dtype dtype) {
        Dtype dtype2 =  findOne(dtype.getId());
        dtypeReposity.delete(dtype2);
    }

    private Specification<Dtype> createFilter(String keyword) {
        List<Predicate> predicates = new ArrayList<>();
        return new Specification<Dtype>() {
            @Override
            public Predicate toPredicate(Root<Dtype> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(keyword)){
                    Predicate id = cb.like(root.get("id").as(String.class), "%" + keyword + "%");
                    Predicate name = cb.like(root.get("d_name").as(String.class), "%" + keyword + "%");
//                    Predicate status = cb.like(root.get("d_status").as(String.class), "%" + keyword + "%");


                    predicates.add(cb.or(id, name));
                }
                Predicate[] p = new Predicate[predicates.size()];

                return cb.and(predicates.toArray(p));
            }
        };
    }
}
