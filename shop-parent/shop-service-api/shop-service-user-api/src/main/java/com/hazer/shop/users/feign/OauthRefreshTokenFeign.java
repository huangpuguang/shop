package com.hazer.shop.users.feign;
import com.github.pagehelper.PageInfo;
import com.hazer.shop.users.pojo.OauthRefreshToken;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author: Hazer
 * @Description:
 *****/
@FeignClient(name="content")
@RequestMapping("/oauthRefreshToken")
public interface OauthRefreshTokenFeign {

    /***
     * OauthRefreshToken分页条件搜索实现
     * @param oauthRefreshToken
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) OauthRefreshToken oauthRefreshToken, @PathVariable  int page, @PathVariable  int size);

    /***
     * OauthRefreshToken分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param oauthRefreshToken
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<OauthRefreshToken>> findList(@RequestBody(required = false) OauthRefreshToken oauthRefreshToken);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable String id);

    /***
     * 修改OauthRefreshToken数据
     * @param oauthRefreshToken
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OauthRefreshToken oauthRefreshToken,@PathVariable String id);

    /***
     * 新增OauthRefreshToken数据
     * @param oauthRefreshToken
     * @return
     */
    @PostMapping
    Result add(@RequestBody OauthRefreshToken oauthRefreshToken);

    /***
     * 根据ID查询OauthRefreshToken数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<OauthRefreshToken> findById(@PathVariable String id);

    /***
     * 查询OauthRefreshToken全部数据
     * @return
     */
    @GetMapping
    Result<List<OauthRefreshToken>> findAll();
}