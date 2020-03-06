package com.hazer.goods.controller;

/**
 * @ClassName: BrandController
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-05 23:14
 **/

import com.github.pagehelper.PageInfo;
import com.hazer.goods.entity.Result;
import com.hazer.goods.entity.StatusCode;
import com.hazer.goods.pojo.Brand;
import com.hazer.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    BrandService brandService;

    /**
     * description: 查询所有品牌
     * @author Hazer
     * @date  23:37
     * @param
     * @return
     */
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll(){
        List<Brand> brandList = brandService.findAll();
        return  new Result<>(true, StatusCode.OK,"查询成功",brandList);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK,"查询成功",brand);
    }

    /**
     * 根据条件查询
     * @param brand
     * @return
     */
    @PostMapping("/findList")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
       List<Brand> brands = brandService.findList(brand);
       return new Result<>(true,StatusCode.OK,"查询成功",brands);
    }

    /**
     * 分页查询
     * @param brand
     * @return
     */
    @PostMapping("/page")
    public Result<PageInfo<Brand>> pageList(@RequestBody Brand brand){
        PageInfo<Brand> brandPageInfo =  brandService.findPage(brand);
        return new Result<>(true,StatusCode.OK,"查询成功",brandPageInfo);
    }

    @PutMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @PutMapping("/update")
    public Result update(@RequestBody Brand brand){
        Brand brandUpdate = brandService.findById(brand.getId());
        if(brandUpdate != null){
            brandService.update(brand);
            return new Result(true,StatusCode.OK,"更新成功");
        }
        return new Result(false,StatusCode.NOTFOUNDERROR,"品牌不存在");
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){

        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
