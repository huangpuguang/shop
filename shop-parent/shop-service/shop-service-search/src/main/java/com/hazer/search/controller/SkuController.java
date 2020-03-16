package com.hazer.search.controller;

import com.hazer.model.Result;
import com.hazer.model.StatusCode;
import com.hazer.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SkuController
 * @description: 类的说明
 * @author: Hazer
 * @create: 2020-03-14 16:15
 **/
@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * 导入数据
     * @return
     */
    @GetMapping("/import")
    public Result search(){
        skuService.importSku();
        return new Result(true, StatusCode.OK,"导入数据到索引库中成功！");
    }
}
