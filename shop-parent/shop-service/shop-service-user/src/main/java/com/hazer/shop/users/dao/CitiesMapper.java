package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Cities;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Cities的Dao
 *****/
@Repository
public interface CitiesMapper extends Mapper<Cities> {
}
