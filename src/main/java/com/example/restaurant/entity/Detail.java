package com.example.restaurant.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-09-10 15:09
 **/
@Entity
@Table(name = "detail")
public class Detail implements Serializable {

    private static final long serialVersionUID =1l;

    @ApiModelProperty(value = "主键", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键

    private String deskId; //餐桌id

    private String d_typeId; //菜系id

    private String dishName; //菜名

    private String price; //单价

    private int count; //数量

    private String status; //是否已结账

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    public String getD_typeId() {
        return d_typeId;
    }

    public void setD_typeId(String d_typeId) {
        this.d_typeId = d_typeId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
