package com.hazer.goods.dao;

import com.hazer.goods.pojo.Album;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName AlbumMapper
 * @Description
 * @Author Hazer
 * @Date 2020/3/6 17:37
 **/
@Repository
public interface AlbumMapper extends Mapper<Album> {
}
