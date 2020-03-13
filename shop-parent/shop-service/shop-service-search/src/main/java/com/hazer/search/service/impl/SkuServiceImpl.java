package com.hazer.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.hazer.goods.fegin.SkuFegin;
import com.hazer.goods.pojo.Sku;
import com.hazer.model.Result;
import com.hazer.search.dao.SkuEsMapper;
import com.hazer.search.pojo.SkuInfo;
import com.hazer.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName SkuServiceImpl
 * @Description
 * @Author Hazer
 * @Date 2020/3/13 11:20
 **/
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuFegin skuFegin;

    @Autowired
    private SkuEsMapper skuEsMapper;
    @Override
    public void importSku() {
        Result<List<Sku>> skuListResult=  skuFegin.findAll();
        JSON.parseArray(JSON.toJSONString(skuListResult.getData()),SkuInfo.class);
    }
}
