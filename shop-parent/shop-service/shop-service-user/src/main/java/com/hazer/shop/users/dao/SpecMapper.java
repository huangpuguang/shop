package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Spec;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Spec的Dao
 *****/
@Repository
public interface SpecMapper extends Mapper<Spec> {
}
