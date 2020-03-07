package com.hazer.goods.dao;
import com.hazer.goods.pojo.UndoLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description:UndoLog的Dao
 *****/
@Repository
public interface UndoLogMapper extends Mapper<UndoLog> {
}
