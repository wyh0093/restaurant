package com.example.restaurant.entity;

import com.example.restaurant.util.Object6Serialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 12:10
 **/
@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    private static final long serialVersionUID =1l;

    @ApiModelProperty(value = "主键", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int d_typeId; //所属菜系
    @Transient
    private String d_typeName; //所属菜系名称

    private String d_name; //菜名

    private Double price; //价格
    @Transient
    private String priceStr;
    @Transient
    private String memberPriceStr;

    private Double memberPrice; //会员价格

    private String descript; //简介

    private String url; //图片路径

    private String imgName; //图片名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getD_typeId() {
        return d_typeId;
    }

    public void setD_typeId(int d_typeId) {
        this.d_typeId = d_typeId;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getD_typeName() {
        return d_typeName;
    }

    public void setD_typeName(String d_typeName) {
        this.d_typeName = d_typeName;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getMemberPriceStr() {
        return memberPriceStr;
    }

    public void setMemberPriceStr(String memberPriceStr) {
        this.memberPriceStr = memberPriceStr;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
