package com.hazer.search.dao;

import com.hazer.goods.pojo.Sku;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName SkuEsMapper
 * @Description
 * @Author Hazer
 * @Date 2020/3/13 11:16
 **/
@Repository
public interface SkuEsMapper extends ElasticsearchRepository<Sku,Long> {

}
