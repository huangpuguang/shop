package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Album;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Album的Dao
 *****/
@Repository
public interface AlbumMapper extends Mapper<Album> {
}
