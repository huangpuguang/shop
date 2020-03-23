package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.UndoLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: UndoLog的Dao
 *****/
@Repository
public interface UndoLogMapper extends Mapper<UndoLog> {
}
