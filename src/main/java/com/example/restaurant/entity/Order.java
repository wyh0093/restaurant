package com.example.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 12:16
 **/
@Entity
@Table(name = "dorder")
public class Order implements Serializable {

    private static final long serialVersionUID =1l;

    @ApiModelProperty(value = "主键", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //订单编号

    private String deskName; //餐桌名称

    private Date time; //下单时间

    private int price;//金额

    private String  status; //状态  0：未结账   1：已结账

   /* private String dishIds; //菜品id*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   /* public String getDishIds() {
        return dishIds;
    }

    public void setDishIds(String dishIds) {
        this.dishIds = dishIds;
    }*/
}
