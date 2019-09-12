package com.example.restaurant.controller;

import com.example.restaurant.entity.Desk;
import com.example.restaurant.entity.Dish;
import com.example.restaurant.service.DishService;
import com.example.restaurant.service.DtypeService;
import com.example.restaurant.util.DataParseUtil;
import com.example.restaurant.util.GetPath;
import com.example.restaurant.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 13:23
 **/
@Api(description = "菜品管理")
@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private DtypeService dtypeService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加菜品")
    public String add(@RequestParam(value = "file") MultipartFile file,
                    @ApiParam(value = "菜品名称")@RequestParam(required = true,value = "name") String name,
                    @ApiParam(value = "菜系名称")@RequestParam(required = true,value = "typeId") int typeId,
                    @ApiParam(value = "菜品描述")@RequestParam(required = false,value = "descript") String descript,
                    @ApiParam(value = "价格")@RequestParam(required = true,value = "price") double price,
                      @ApiParam(value = "id")@RequestParam(required = false,value = "id") String id){
        Dish dish = new Dish();
        if(!"".equals(id)){
            dish = dishService.findOne(Integer.parseInt(id));
        }
        dish.setD_name(name);
        dish.setD_typeId(typeId);
        dish.setDescript(descript);
        dish.setPrice(DataParseUtil.oneDecimal(price));
        dish.setMemberPrice(DataParseUtil.oneDecimal(price*0.8));
        if (file.isEmpty()) {
            System.out.println("文件为空！");
        }else {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            File upload = new File(GetPath.getClassPath()+"images/");// 上传后的路径
            if(!upload.exists()) upload.mkdirs();
            fileName = UUID.randomUUID() + suffixName; // 新文件名
//            System.out.println(upload.getPath());
            File dest = new File(upload.getPath()+"/" + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(dest.getPath());
            dish.setUrl(dest.getPath());
            dish.setImgName(fileName);
        }
        dishService.save(dish);
        return "success";
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    @ApiOperation(value = "获取单个菜品")
    public String findOne(@ApiParam(value = "餐品id") @RequestParam int id){
        Dish dish = dishService.findOne(id);
        return  JsonUtil.parseJsonStr(dish);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "修改菜品")
    public String update(@ApiParam(value = "餐品实体") @RequestBody Dish dish,@ApiParam(value = "餐品id") @RequestParam int id){
        Dish dish1 = dishService.findOne(id);

        BeanUtils.copyProperties(dish,dish1);
        dishService.save(dish1);
        return  "success";
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ApiOperation(value = "获取餐品数据", notes = "")
    public Page<Dish> findAll(@ApiParam(value = "当前页数") @RequestParam(required = true) int page,
                              @ApiParam(value = "每页的条数") @RequestParam(required = true) int pageSize,
                              @ApiParam(value = "关键字") @RequestParam(required = false) String keyword,
                              @ApiParam(value = "菜系") @RequestParam(required = true) int typeId){
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        PageRequest pageable = new PageRequest(page-1,pageSize,sort);
        Page<Dish> dishs =  dishService.findAll(keyword,typeId,pageable);
        List<Dish> list = dishs.getContent();
        for(int i=0;i<list.size();i++){
            Dish dish = list.get(i);
            dishs.getContent().get(i).setPriceStr(DataParseUtil.oneDecimal(dish.getPrice()).toString());
            dishs.getContent().get(i).setMemberPriceStr(DataParseUtil.oneDecimal(dish.getMemberPrice()).toString());
            dishs.getContent().get(i).setD_typeName(dtypeService.findOne(dish.getD_typeId()).getD_name());
        }
        return dishs;
    }



}
