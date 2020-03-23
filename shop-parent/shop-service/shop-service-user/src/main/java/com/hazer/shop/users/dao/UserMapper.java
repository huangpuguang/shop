package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: User的Dao
 *****/
@Repository
public interface UserMapper extends Mapper<User> {
}
