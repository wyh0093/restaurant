package com.example.restaurant.service.serviceImpl;

import com.example.restaurant.entity.Detail;
import com.example.restaurant.repository.DetailReposity;
import com.example.restaurant.service.DetailsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 15:03
 **/
@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailReposity detailReposity;
    @Override
    public void save(Detail detail) {
        detailReposity.save(detail);
    }

    @Override
    public void deleteById(int id) {
        detailReposity.deleteById(id);
    }

    @Override
    public List<Detail> findByDeskName(String deskName) {
        List<Detail> list = detailReposity.findByDeskName(deskName);
        return list;
    }

    @Override
    public int getPricesByDeskName(String deskName) {
        int totalPrices=0 ;
        List<Detail> list = this.findByDeskName(deskName);
        if(list!=null && list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                Detail detail = list.get(i);
                int prices = detail.getPrice()*detail.getCount();
                totalPrices+=prices;
            }
        }
        return totalPrices;
    }
}
