package com.hazer.shop.users.service;
import com.hazer.shop.users.pojo.OauthRefreshToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author: Hazer
 * @Description: OauthRefreshToken业务层接口
 *****/
public interface OauthRefreshTokenService {

    /***
     * OauthRefreshToken多条件分页查询
     * @param oauthRefreshToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthRefreshToken> findPage(OauthRefreshToken oauthRefreshToken, int page, int size);

    /***
     * OauthRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OauthRefreshToken> findPage(int page, int size);

    /***
     * OauthRefreshToken多条件搜索方法
     * @param oauthRefreshToken
     * @return
     */
    List<OauthRefreshToken> findList(OauthRefreshToken oauthRefreshToken);

    /***
     * 删除OauthRefreshToken
     * @param id
     */
    void delete(String id);

    /***
     * 修改OauthRefreshToken数据
     * @param oauthRefreshToken
     */
    void update(OauthRefreshToken oauthRefreshToken);

    /***
     * 新增OauthRefreshToken
     * @param oauthRefreshToken
     */
    void add(OauthRefreshToken oauthRefreshToken);

    /**
     * 根据ID查询OauthRefreshToken
     * @param id
     * @return
     */
     OauthRefreshToken findById(String id);

    /***
     * 查询所有OauthRefreshToken
     * @return
     */
    List<OauthRefreshToken> findAll();
}
