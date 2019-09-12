package com.example.restaurant.service.serviceImpl;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.repository.DeskRepository;
import com.example.restaurant.service.DeskService;
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
import java.util.Date;
import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 18:35
 **/
@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskRepository deskRepository;

    @Override
    public Desk findOne(Integer id) {
        Desk d = deskRepository.findById(id).get();
        return d;
    }

    @Override
    public void save(Desk desk) {
        desk.setD_status("预订");
        deskRepository.save(desk);
    }

    @Override
    public void update(Desk desk) {
        if("预订".equals(desk.getD_status())){
            desk.setD_status("退桌");
            desk.setD_bookTime(new Date());
        }else {
            desk.setD_status("预订");
            desk.setD_bookTime(null);
        }
        deskRepository.save(desk);

    }

    @Override
    public Page<Desk> findAll(String keyword, PageRequest pageable) {
        Page<Desk> all = this.deskRepository.findAll(createFilter(keyword), pageable);
        return all;
    }

    @Override
    public void del(Desk desk) {
        Desk desk1 = this.deskRepository.getOne(desk.getId());
        this.deskRepository.delete(desk1);
    }

    private Specification<Desk> createFilter(String keyword) {
        List<Predicate> predicates = new ArrayList<>();

        return new Specification<Desk>() {
            @Override
            public Predicate toPredicate(Root<Desk> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(keyword)){
                    Predicate id = cb.like(root.get("id").as(String.class), "%" + keyword + "%");
                    Predicate name = cb.like(root.get("d_name").as(String.class), "%" + keyword + "%");
                    Predicate status = cb.like(root.get("d_status").as(String.class), "%" + keyword + "%");


                    predicates.add(cb.or(id, name,status));
                }
                Predicate[] p = new Predicate[predicates.size()];

                return cb.and(predicates.toArray(p));
            }
        };
    }
}
