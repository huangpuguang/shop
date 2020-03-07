package com.hazer.goods.dao;
import com.hazer.goods.pojo.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description:Brand的Dao
 *****/
@Repository
public interface BrandMapper extends Mapper<Brand> {
}
