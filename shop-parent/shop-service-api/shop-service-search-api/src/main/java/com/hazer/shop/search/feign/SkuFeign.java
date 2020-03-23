package com.hazer.shop.search.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 描述
 *
 * @author Hazer
 * @version 1.0
 * @package com.hazer.shop.search.feign *
 * @since 1.0
 */
@FeignClient(name="search")
@RequestMapping("/search")
public interface SkuFeign {
    @GetMapping
    public Map search(@RequestParam(required = false) Map searchMap);
}
