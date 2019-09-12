package com.example.restaurant.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.restaurant.util.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-07 17:35
 **/
@Entity
@Table(name = "desk")
public class Desk implements Serializable {

    private static final long serialVersionUID =1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JSONField(serialize=false)
    private Integer id;

    private String d_name; //餐桌名称

    private String d_status; //餐桌专状态

    private Date d_bookTime; //预订时间

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

    public String getD_status() {
        return d_status;
    }

    public void setD_status(String d_status) {
        this.d_status = d_status;
    }

    public Date getD_bookTime() {
        return d_bookTime;
    }

    public void setD_bookTime(Date d_bookTime) {
        this.d_bookTime = d_bookTime;
    }
}
