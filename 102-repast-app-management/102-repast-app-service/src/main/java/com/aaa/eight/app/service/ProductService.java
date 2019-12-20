package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ProductMapper;
import com.aaa.eight.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 10:38
 **/
@Service
public class ProductService extends BaseService<Product> {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }
}
