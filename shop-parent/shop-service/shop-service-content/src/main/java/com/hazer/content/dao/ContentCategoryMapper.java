package com.hazer.content.dao;
import com.hazer.content.pojo.ContentCategory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description:ContentCategory的Dao
 *****/
@Repository
public interface ContentCategoryMapper extends Mapper<ContentCategory> {
}
