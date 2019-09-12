package com.example.restaurant.dto;

import com.example.restaurant.entity.Dtype;

import java.io.Serializable;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-09-11 16:27
 **/
public class DtypeDto implements Serializable {

    private static final long serialVersionUID =1l;

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
