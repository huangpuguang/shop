package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.OauthRefreshToken;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: OauthRefreshToken的Dao
 *****/
@Repository
public interface OauthRefreshTokenMapper extends Mapper<OauthRefreshToken> {
}
