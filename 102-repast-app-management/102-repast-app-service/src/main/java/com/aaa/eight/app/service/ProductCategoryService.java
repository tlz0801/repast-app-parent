package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ProductCategoryMapper;
import com.aaa.eight.app.model.ProductCategory;
import com.aaa.eight.app.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: wyy
 * @Param:
 * @Date: 2019/12/23 16:08
 */
@Service
public class ProductCategoryService extends BaseService<ProductCategory> {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private Map<String,Object> hashMap;
    @Override
    public Mapper<ProductCategory> getMapper() {
        return productCategoryMapper;
    }
    public List<ProductCategory> listAll(){
        List<ProductCategory> listall = productCategoryMapper.selectAll();
        if (null == listall){
            hashMap.put("code", StatusEnum.NOT_EXIST.getCode());
            hashMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
        }
        return listall;
    }
}
