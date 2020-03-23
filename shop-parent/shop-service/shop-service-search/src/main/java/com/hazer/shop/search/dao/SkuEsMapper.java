package com.hazer.shop.search.dao;

import com.hazer.shop.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 描述
 *
 * @author Hazer
 * @version 1.0
 * @package com.hazer.shop.search.dao *
 * @since 1.0
 */
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo,Long> {
}
