package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Template;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Template的Dao
 *****/
@Repository
public interface TemplateMapper extends Mapper<Template> {
}
