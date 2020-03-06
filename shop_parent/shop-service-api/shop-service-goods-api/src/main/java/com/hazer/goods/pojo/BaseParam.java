package com.hazer.goods.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Transient;

/**
 * @ClassName BaseParam
 * @Description 基础类
 * @Author Hazer
 * @Date 2020/3/6 15:56
 **/
public class BaseParam {
    @ApiModelProperty(value = "当前页",required = false)
    @Transient   //不与数据库映射
    Integer currentPage = 1;
    @Transient
    @ApiModelProperty(value = "每页数据",required = false)
    Integer pageSize = 10;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
