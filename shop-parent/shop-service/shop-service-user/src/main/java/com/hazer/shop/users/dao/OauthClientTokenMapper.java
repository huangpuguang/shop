package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.OauthClientToken;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: OauthClientToken的Dao
 *****/
@Repository
public interface OauthClientTokenMapper extends Mapper<OauthClientToken> {
}
