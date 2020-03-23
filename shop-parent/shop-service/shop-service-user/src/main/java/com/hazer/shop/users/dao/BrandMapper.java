package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Brand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Brand的Dao
 *****/
@Repository
public interface BrandMapper extends Mapper<Brand> {
}
