package com.hazer.content.dao;
import com.hazer.content.pojo.Content;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description:Content的Dao
 *****/
@Repository
public interface ContentMapper extends Mapper<Content> {
}
