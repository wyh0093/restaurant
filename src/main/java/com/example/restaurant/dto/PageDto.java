package com.example.restaurant.dto;

import java.io.Serializable;

/**
 * @program: restaurant
 * @description:
 * @author: Yunhuan Wang
 * @create: 2019-08-08 10:38
 **/
public class PageDto implements Serializable {

    private static final long serialVersionUID =1l;

    private int page; //当前页

    private int pageSize; //每页条数

    private String keyword; //关键字

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
