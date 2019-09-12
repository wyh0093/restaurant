package com.example.restaurant.controller;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.service.DeskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 18:18
 **/
@Api(description = "餐桌管理")
@RestController
@RequestMapping("/desk")
public class DeskController{

    @Autowired
    private DeskService deskService;

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ApiOperation(value = "获取餐桌数据", notes = "")
    public Page<Desk> findAll(@ApiParam(value = "当前页数") @RequestParam(required = true) int page,
                          @ApiParam(value = "每页的条数") @RequestParam(required = true) int pageSize,
                          @ApiParam(value = "关键字") @RequestParam(required = false) String keyword){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        PageRequest pageable = new PageRequest(page-1,pageSize,sort);
        Page<Desk> desk =  deskService.findAll(keyword,pageable);
        return desk;
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "餐桌修改")
    public String update(@ApiParam(value = "餐桌实体") @RequestBody Desk desk){
        Desk desk2 = deskService.findOne(desk.getId());
        desk2.setD_status(desk.getD_status());
        deskService.update(desk2);
        return "success";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "餐桌添加")
    public String save(@ApiParam(value = "餐桌实体") @RequestBody Desk desk){
        deskService.save(desk);
        return "success";
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ApiOperation(value = "餐桌删除")
    public String del(@ApiParam(value = "餐桌实体") @RequestBody Desk desk){
        deskService.del(desk);
        return "success";
    }



}
