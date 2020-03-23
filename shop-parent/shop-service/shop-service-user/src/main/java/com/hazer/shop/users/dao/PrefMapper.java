package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Pref;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Pref的Dao
 *****/
@Repository
public interface PrefMapper extends Mapper<Pref> {
}
