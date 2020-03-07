package com.hazer.goods.dao;
import com.hazer.goods.pojo.Sku;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description:Sku的Dao
 *****/
@Repository
public interface SkuMapper extends Mapper<Sku> {
}
