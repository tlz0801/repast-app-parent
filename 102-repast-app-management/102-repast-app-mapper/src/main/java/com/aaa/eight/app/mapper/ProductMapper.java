package com.aaa.eight.app.mapper;

import com.aaa.eight.app.model.Product;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {
    List<Product> findAll();
}