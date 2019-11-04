package com.example.restaurant.controller;

import com.example.restaurant.entity.Detail;
import com.example.restaurant.service.DetailsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-10-17 15:59
 **/
@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation("添加订单详细")
    public void save(@ApiParam(value = "菜名") @RequestParam(required = true) String dishNames,
                     @ApiParam(value = "单价") @RequestParam(required = true) String prices,
                     @ApiParam(value = "数量") @RequestParam(required = true) String numbers,
                     @ApiParam(value = "餐桌名") @RequestParam(required = true) String deskName){

        String[] dishNameAyy = dishNames.contains(",")?dishNames.split(","):new String[]{dishNames};
        String[] pricesAyy = prices.contains(",")?prices.split(","):new String[]{prices};
        String[] numbersAyy = numbers.contains(",")?numbers.split(","):new String[]{numbers};
        if(dishNameAyy.length>1){
            for(int i=0;i<dishNameAyy.length;i++){
                Detail detail = new Detail();
                detail.setDishName(dishNameAyy[i]);
                detail.setPrice(Integer.parseInt(pricesAyy[i]));
                detail.setDeskName(deskName);
                detail.setCount(Integer.parseInt(numbersAyy[i]));
                detail.setStatus("0");
                detailsService.save(detail);
            }
        }

    }
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ApiOperation("根据id删除详细订单")
    public void deleteById(@ApiParam(value = "详细订单id") @PathVariable("id") int id){
        detailsService.deleteById(id);
    }
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    @ApiOperation("根据餐桌名称修改订单状态名称")
    public void updateStatusByDeskName(@ApiParam(value = "餐桌名") @RequestParam(required = true) String deskName){

    }
}
