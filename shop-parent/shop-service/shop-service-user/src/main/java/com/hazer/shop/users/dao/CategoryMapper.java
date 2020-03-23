package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Category的Dao
 *****/
@Repository
public interface CategoryMapper extends Mapper<Category> {
}
