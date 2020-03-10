package com.hazer.goods.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Goods
 * @description: 
 * @author: Hazer
 * @create: 2020-03-08 16:40
 **/
@Data
public class Goods implements Serializable {
    //SPU
    private Spu spu;
    //SKU集合
    private List<Sku> skuList;

}
