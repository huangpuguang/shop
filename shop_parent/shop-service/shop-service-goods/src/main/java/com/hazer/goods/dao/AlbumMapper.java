package com.hazer.goods.dao;
import com.hazer.goods.pojo.Album;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description:Album的Dao
 *****/
@Repository
public interface AlbumMapper extends Mapper<Album> {
}
