package com.hazer.goods.dao;
import com.hazer.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author: Hazer
 * @Description:Brand的Dao
 *****/
@Repository
public interface BrandMapper extends Mapper<Brand> {
    /***
     * 查询分类对应的品牌集合
     */
    @Select("SELECT tb.* FROM tb_category_brand tcb,tb_brand tb WHERE tcb.category_id=#{categoryid} AND tb.id=tcb.brand_id")
    List<Brand> findByCategory(Integer categoryId);
}
