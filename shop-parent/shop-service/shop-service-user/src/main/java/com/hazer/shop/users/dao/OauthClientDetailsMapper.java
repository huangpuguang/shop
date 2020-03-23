package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.OauthClientDetails;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: OauthClientDetails的Dao
 *****/
@Repository
public interface OauthClientDetailsMapper extends Mapper<OauthClientDetails> {
}
