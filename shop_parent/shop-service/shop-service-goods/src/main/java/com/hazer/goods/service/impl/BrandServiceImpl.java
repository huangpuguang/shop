package com.hazer.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hazer.goods.dao.BrandMapper;
import com.hazer.goods.pojo.Brand;
import com.hazer.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.RollbackException;
import java.util.List;

/**
 * @ClassName: BrandServiceImpl
 * @description:
 * @author: Hazer
 * @create: 2020-03-05 23:12
 **/
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand) {
        PageHelper.startPage(brand.getCurrentPage(),brand.getPageSize());
        Example example = createExample(brand);
        List<Brand> brandList = brandMapper.selectByExample(example);
        return new PageInfo<>(brandList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    private Example createExample(Brand brand){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if( !StringUtils.isEmpty(brand.getLetter())){
            criteria.andEqualTo("letter",brand.getLetter());
        }
        if(!StringUtils.isEmpty(brand.getName())){
            criteria.andLike("name","%"+brand.getName()+"%");
        }
        if(!StringUtils.isEmpty(brand.getImage())){
            criteria.andLike("image","%"+brand.getImage()+"%");
        }
        return example;
    }
}
