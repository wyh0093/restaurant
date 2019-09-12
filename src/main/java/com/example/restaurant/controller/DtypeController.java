package com.example.restaurant.controller;

import com.example.restaurant.dto.DtypeDto;
import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dtype;
import com.example.restaurant.service.DtypeService;
import com.example.restaurant.util.DataUtil;
import com.example.restaurant.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 14:27
 **/
@Api(description = "菜系管理")
@RestController
@RequestMapping("/dtype")
public class DtypeController {

    @Autowired
    private DtypeService dtypeService;

    @RequestMapping(value = "/findAllByPage",method = RequestMethod.POST)
    @ApiOperation(value = "获取所有菜系")
    public String findAllByPage(@ApiParam(value = "当前页数") @RequestParam(required = true) int page,
                          @ApiParam(value = "每页的条数") @RequestParam(required = true) int pageSize,
                          @ApiParam(value = "关键字") @RequestParam(required = false) String keyword){

        Sort sort=new Sort(Sort.Direction.ASC,"id");
        PageRequest pageable = new PageRequest(page-1,pageSize,sort);
        Page<Dtype> dtype =  dtypeService.findAll(keyword,pageable);
        return JsonUtil.parseJsonStr(dtype);
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ApiOperation(value = "获取所有菜系")
    public String findAll(){
        List<Dtype> list = dtypeService.findAllData();
        return JsonUtil.parseJsonStr(list);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "餐系修改")
    public String update(@ApiParam(value = "餐系实体") @RequestBody Dtype dtype){

        Dtype dtype2 = dtypeService.findOne(dtype.getId());
        dtype2.setD_name(dtype.getD_name());
        dtypeService.save(dtype2);
        return "success";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "餐系添加")
    public String save(@ApiParam(value = "餐系实体") @RequestBody DtypeDto dtype){
        Dtype type = new Dtype();
        BeanUtils.copyProperties(dtype,type);
        dtypeService.save(type);
        return "success";
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ApiOperation(value = "菜系删除")
    public String del(@ApiParam(value = "餐系实体") @RequestBody Dtype dtype){
        dtypeService.del(dtype);
        return "success";
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    @ApiOperation(value = "查询单个菜系")
    public String findOne(@ApiParam(value = "餐系id") @RequestParam int id){
        Dtype dtype = dtypeService.findOne(id);
        return JsonUtil.parseJsonStr(dtype);
    }

}
