package com.hazer.shop.users.dao;
import com.hazer.shop.users.pojo.Address;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author: Hazer
 * @Description: Address的Dao
 *****/
@Repository
public interface AddressMapper extends Mapper<Address> {
}
