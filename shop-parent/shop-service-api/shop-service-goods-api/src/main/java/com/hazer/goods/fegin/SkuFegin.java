package com.hazer.goods.fegin;

import com.hazer.goods.pojo.Sku;
import com.hazer.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName SkuFegin
 * @Description
 * @Author Hazer
 * @Date 2020/3/13 11:01
 **/
@FeignClient(name = "goods")
@RequestMapping("/sku")
public interface SkuFegin {
    @GetMapping("/findAll")
    public Result<List<Sku>> findAll();

}
