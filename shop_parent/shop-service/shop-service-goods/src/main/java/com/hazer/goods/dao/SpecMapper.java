package com.hazer.goods.dao;

import com.hazer.goods.pojo.Spec;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: SpecMapper
 * @description: 规格管理
 * @author: Hazer
 * @create: 2020-03-07 00:18
 **/
@Repository
public interface SpecMapper extends Mapper<Spec> {
}
