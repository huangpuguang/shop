package com.hazer.shop.users.service.impl;
import com.hazer.shop.users.dao.OauthRefreshTokenMapper;
import com.hazer.shop.users.pojo.OauthRefreshToken;
import com.hazer.shop.users.service.OauthRefreshTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/****
 * @Author: Hazer
 * @Description:OauthRefreshToken业务层接口实现类
 *****/
@Service
public class OauthRefreshTokenServiceImpl implements OauthRefreshTokenService {

    @Autowired
    private OauthRefreshTokenMapper oauthRefreshTokenMapper;


    /**
     * OauthRefreshToken条件+分页查询
     * @param oauthRefreshToken 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OauthRefreshToken> findPage(OauthRefreshToken oauthRefreshToken, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(oauthRefreshToken);
        //执行搜索
        return new PageInfo<OauthRefreshToken>(oauthRefreshTokenMapper.selectByExample(example));
    }

    /**
     * OauthRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OauthRefreshToken> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OauthRefreshToken>(oauthRefreshTokenMapper.selectAll());
    }

    /**
     * OauthRefreshToken条件查询
     * @param oauthRefreshToken
     * @return
     */
    @Override
    public List<OauthRefreshToken> findList(OauthRefreshToken oauthRefreshToken){
        //构建查询条件
        Example example = createExample(oauthRefreshToken);
        //根据构建的条件查询数据
        return oauthRefreshTokenMapper.selectByExample(example);
    }


    /**
     * OauthRefreshToken构建查询对象
     * @param oauthRefreshToken
     * @return
     */
    public Example createExample(OauthRefreshToken oauthRefreshToken){
        Example example=new Example(OauthRefreshToken.class);
        Example.Criteria criteria = example.createCriteria();
        if(oauthRefreshToken!=null){
            // 
            if(!StringUtils.isEmpty(oauthRefreshToken.getTokenId())){
                    criteria.andEqualTo("tokenId",oauthRefreshToken.getTokenId());
            }
            // 
            if(!StringUtils.isEmpty(oauthRefreshToken.getToken())){
                    criteria.andEqualTo("token",oauthRefreshToken.getToken());
            }
            // 
            if(!StringUtils.isEmpty(oauthRefreshToken.getAuthentication())){
                    criteria.andEqualTo("authentication",oauthRefreshToken.getAuthentication());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String id){
        oauthRefreshTokenMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OauthRefreshToken
     * @param oauthRefreshToken
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(OauthRefreshToken oauthRefreshToken){
        oauthRefreshTokenMapper.updateByPrimaryKey(oauthRefreshToken);
    }

    /**
     * 增加OauthRefreshToken
     * @param oauthRefreshToken
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(OauthRefreshToken oauthRefreshToken){
        oauthRefreshTokenMapper.insert(oauthRefreshToken);
    }

    /**
     * 根据ID查询OauthRefreshToken
     * @param id
     * @return
     */
    @Override
    public OauthRefreshToken findById(String id){
        return  oauthRefreshTokenMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OauthRefreshToken全部数据
     * @return
     */
    @Override
    public List<OauthRefreshToken> findAll() {
        return oauthRefreshTokenMapper.selectAll();
    }
}
