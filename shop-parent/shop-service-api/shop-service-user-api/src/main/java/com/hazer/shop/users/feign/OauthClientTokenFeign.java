package com.hazer.shop.users.feign;
import com.github.pagehelper.PageInfo;
import com.hazer.shop.users.pojo.OauthClientToken;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author: Hazer
 * @Description:
 *****/
@FeignClient(name="content")
@RequestMapping("/oauthClientToken")
public interface OauthClientTokenFeign {

    /***
     * OauthClientToken分页条件搜索实现
     * @param oauthClientToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) OauthClientToken oauthClientToken, @PathVariable  int page, @PathVariable  int size);

    /***
     * OauthClientToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param oauthClientToken
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<OauthClientToken>> findList(@RequestBody(required = false) OauthClientToken oauthClientToken);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改OauthClientToken数据
     * @param oauthClientToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OauthClientToken oauthClientToken,@PathVariable String id);

    /***
     * 新增OauthClientToken数据
     * @param oauthClientToken
     * @return
     */
    @PostMapping
    Result add(@RequestBody OauthClientToken oauthClientToken);

    /***
     * 根据ID查询OauthClientToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<OauthClientToken> findById(@PathVariable String id);

    /***
     * 查询OauthClientToken全部数据
     * @return
     */
    @GetMapping
    Result<List<OauthClientToken>> findAll();
}