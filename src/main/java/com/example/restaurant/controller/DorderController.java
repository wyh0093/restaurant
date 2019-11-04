package com.example.restaurant.controller;

import com.example.restaurant.entity.Detail;
import com.example.restaurant.entity.Dtype;
import com.example.restaurant.entity.Order;
import com.example.restaurant.service.DetailsService;
import com.example.restaurant.service.DorderService;
import com.example.restaurant.util.JsonUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 15:05
 **/
@RestController
@RequestMapping("/order")
public class DorderController {

    @Autowired
    private DetailsService detailsService;
    @Autowired
    private DorderService orderService;

    @RequestMapping("/save")
    @ApiOperation(value = "生成订单")
    public void save(
                     @ApiParam(value = "餐桌名") @RequestParam(required = true) String deskName){
            //生成订单
        Order order = new Order();
        order.setDeskName(deskName);
        order.setStatus("0");
        order.setTime(new Date());
        order.setPrice(detailsService.getPricesByDeskName(deskName));
        orderService.save(order);
    }
    @RequestMapping(value = "/updateSatus",method = RequestMethod.GET)
    @ApiOperation(value = "修改订单状态为已结账")
    public void updateSatus(@ApiParam(value = "详细订单id") @PathVariable("id") int id){
        Order order = orderService.findById(id);
        order.setStatus("1");
        orderService.save(order);
    }

    @RequestMapping(value = "/findAllByPage",method = RequestMethod.POST)
    @ApiOperation(value = "获取所有菜系")
    public String findAllByPage(@ApiParam(value = "当前页数") @RequestParam(required = true) int page,
                                @ApiParam(value = "每页的条数") @RequestParam(required = true) int pageSize,
                                @ApiParam(value = "关键字") @RequestParam(required = false) String keyword){

        Sort sort=new Sort(Sort.Direction.ASC,"id");
        PageRequest pageable = new PageRequest(page-1,pageSize,sort);
        Page<Order> orders =  orderService.findAll(pageable);
        return JsonUtil.parseJsonStr(orders);
    }
}
