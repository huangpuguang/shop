package com.hazer.goods.service;

import com.github.pagehelper.PageInfo;
import com.hazer.goods.pojo.Brand;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @ClassName: BrandService
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-05 23:13
 **/
public interface BrandService {
    /**
     * 查询所有品牌
     *
     * @return
     */
    List<Brand> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 条件查询
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页查询
     * @param brand
     * @return
     */
    PageInfo<Brand> findPage(Brand brand);

    /**
     * 新增品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    void update(Brand brand);


    /**
     * 删除品牌
     * @param id
     */
    void delete (Integer id);
}
