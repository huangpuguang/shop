package com.hazer.shop.users.controller;
import com.hazer.shop.users.pojo.OauthRefreshToken;
import com.hazer.shop.users.service.OauthRefreshTokenService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import com.hazer.model.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author: Hazer
 * @Description:
 *****/
@Api(value = "OauthRefreshTokenController")
@RestController
@RequestMapping("/oauthRefreshToken")
@CrossOrigin
public class OauthRefreshTokenController {

    @Autowired
    private OauthRefreshTokenService oauthRefreshTokenService;

    /***
     * OauthRefreshToken分页条件搜索实现
     * @param oauthRefreshToken
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken条件分页查询",notes = "分页条件查询OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "OauthRefreshToken对象",value = "传入JSON数据",required = false) OauthRefreshToken oauthRefreshToken, @PathVariable  int page, @PathVariable  int size){
        //调用OauthRefreshTokenService实现分页条件查询OauthRefreshToken
        PageInfo<OauthRefreshToken> pageInfo = oauthRefreshTokenService.findPage(oauthRefreshToken, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * OauthRefreshToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken分页查询",notes = "分页查询OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用OauthRefreshTokenService实现分页查询OauthRefreshToken
        PageInfo<OauthRefreshToken> pageInfo = oauthRefreshTokenService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param oauthRefreshToken
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken条件查询",notes = "条件查询OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @PostMapping(value = "/search" )
    public Result<List<OauthRefreshToken>> findList(@RequestBody(required = false) @ApiParam(name = "OauthRefreshToken对象",value = "传入JSON数据",required = false) OauthRefreshToken oauthRefreshToken){
        //调用OauthRefreshTokenService实现条件查询OauthRefreshToken
        List<OauthRefreshToken> list = oauthRefreshTokenService.findList(oauthRefreshToken);
        return new Result<List<OauthRefreshToken>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken根据ID删除",notes = "根据ID删除OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用OauthRefreshTokenService实现根据主键删除
        oauthRefreshTokenService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改OauthRefreshToken数据
     * @param oauthRefreshToken
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken根据ID修改",notes = "根据ID修改OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "OauthRefreshToken对象",value = "传入JSON数据",required = false) OauthRefreshToken oauthRefreshToken,@PathVariable String id){
        //设置主键值
        oauthRefreshToken.setTokenId(id);
        //调用OauthRefreshTokenService实现修改OauthRefreshToken
        oauthRefreshTokenService.update(oauthRefreshToken);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增OauthRefreshToken数据
     * @param oauthRefreshToken
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken添加",notes = "添加OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "OauthRefreshToken对象",value = "传入JSON数据",required = true) OauthRefreshToken oauthRefreshToken){
        //调用OauthRefreshTokenService实现添加OauthRefreshToken
        oauthRefreshTokenService.add(oauthRefreshToken);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询OauthRefreshToken数据
     * @param id
     * @return
     */
    @ApiOperation(value = "OauthRefreshToken根据ID查询",notes = "根据ID查询OauthRefreshToken方法详情",tags = {"OauthRefreshTokenController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<OauthRefreshToken> findById(@PathVariable String id){
        //调用OauthRefreshTokenService实现根据主键查询OauthRefreshToken
        OauthRefreshToken oauthRefreshToken = oauthRefreshTokenService.findById(id);
        return new Result<OauthRefreshToken>(true,StatusCode.OK,"查询成功",oauthRefreshToken);
    }

    /***
     * 查询OauthRefreshToken全部数据
     * @return
     */
    @ApiOperation(value = "查询所有OauthRefreshToken",notes = "查询所OauthRefreshToken有方法详情",tags = {"OauthRefreshTokenController"})
    @GetMapping
    public Result<List<OauthRefreshToken>> findAll(){
        //调用OauthRefreshTokenService实现查询所有OauthRefreshToken
        List<OauthRefreshToken> list = oauthRefreshTokenService.findAll();
        return new Result<List<OauthRefreshToken>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
