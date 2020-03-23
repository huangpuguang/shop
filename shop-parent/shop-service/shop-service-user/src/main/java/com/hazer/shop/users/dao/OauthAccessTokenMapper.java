package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.OauthAccessToken;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: OauthAccessToken的Dao
 *****/
@Repository
public interface OauthAccessTokenMapper extends Mapper<OauthAccessToken> {
}
