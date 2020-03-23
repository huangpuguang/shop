package com.hazer.shop.goods.dao;
import com.hazer.shop.goods.pojo.UndoLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:admin
 * @Description:UndoLog的Dao
 * @Date 2019/6/14 0:12
 *****/
@Repository
public interface UndoLogMapper extends Mapper<UndoLog> {
}
