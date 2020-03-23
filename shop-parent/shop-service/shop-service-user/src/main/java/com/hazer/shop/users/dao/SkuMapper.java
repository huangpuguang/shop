package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Sku;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Sku的Dao
 *****/
@Repository
public interface SkuMapper extends Mapper<Sku> {
}
