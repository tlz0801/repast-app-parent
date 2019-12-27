package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ProductAttributeMapper;
import com.aaa.eight.app.model.ProductAttribute;
import com.aaa.eight.app.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: wyy
 * @Param:商品属性参数
 * @Date: 2019/12/21 0:51
 */
@Service
public class ProductAttributeService extends BaseService<ProductAttribute> {
    @Autowired
    private ProductAttributeMapper productAttributeMapper;
    @Autowired
    private Map<String,Object> hashMap;
    @Override
    public Mapper<ProductAttribute> getMapper() {
        return productAttributeMapper;
    }
    public List<ProductAttribute> list(){
        List<ProductAttribute> list = productAttributeMapper.selectAll();
        if (null == list){
            hashMap.put("code", StatusEnum.NOT_EXIST.getCode());
            hashMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
        }
        return list;
    }
}
