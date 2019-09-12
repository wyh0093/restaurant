package com.example.restaurant.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 12:12
 **/
@Entity
@Table(name = "dtype")
public class Dtype {

    private static final long serialVersionUID =1l;

    @ApiModelProperty(value = "主键", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String d_name; //菜系名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }
}
