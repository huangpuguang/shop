package com.hazer.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.hazer.goods.feign.SkuFegin;
import com.hazer.goods.pojo.Sku;
import com.hazer.model.Result;
import com.hazer.search.dao.SkuEsMapper;
import com.hazer.search.pojo.SkuInfo;
import com.hazer.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SkuServiceImpl
 * @Description
 * @Author Hazer
 * @Date 2020/3/13 11:20
 **/
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuFegin skuFegin;

    @Autowired
    private SkuEsMapper skuEsMapper;
    @Override
    public void importSku() {
        Result<List<Sku>> skuListResult=  skuFegin.findAll();
        List<SkuInfo> skuInfos = JSON.parseArray(JSON.toJSONString(skuListResult.getData()),SkuInfo.class);
        for(SkuInfo skuInfo:skuInfos){
            Map<String, Object> specMap= JSON.parseObject(skuInfo.getSpec()) ;
            skuInfo.setSpecMap(specMap);
        }
        skuEsMapper.saveAll(skuInfos);
    }
}
