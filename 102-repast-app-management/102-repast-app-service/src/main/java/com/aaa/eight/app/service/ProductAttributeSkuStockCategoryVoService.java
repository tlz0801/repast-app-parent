package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ProductMapper;
import com.aaa.eight.app.status.StatusEnum;
import com.aaa.eight.app.vo.ProductAttributeSkuStockCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @Author: wyy
 * @Param:商品详情业务
 * @Date: 2019/12/23 14:40
 */
@Service
public class ProductAttributeSkuStockCategoryVoService extends BaseService<ProductAttributeSkuStockCategoryVo> {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private Map<String,Object> hashMap;

    @Override
    public Mapper<ProductAttributeSkuStockCategoryVo> getMapper() {
        return null;
    }

    public List<ProductAttributeSkuStockCategoryVo> getAll(ProductAttributeSkuStockCategoryVo productAttributeSkuStockCategoryVo) {

        List<ProductAttributeSkuStockCategoryVo> getAllId = productMapper.getAll(productAttributeSkuStockCategoryVo);

        if (null == getAllId){

            hashMap.put("code", StatusEnum.NOT_EXIST.getCode());
            hashMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
        }

        return getAllId;

    }

}

