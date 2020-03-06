package com.hazer.goods.dao;

import com.hazer.goods.pojo.Template;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: TemplateMapper
 * @description: 模板管理
 * @author: Hazer
 * @create: 2020-03-07 00:17
 **/
@Repository
public interface TemplateMapper extends Mapper<Template> {
}
