package com.aaa.eight.app.controller;

import com.aaa.eight.app.model.ProductAttribute;
import com.aaa.eight.app.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wyy
 * @Param:商品属性参数
 * @Date: 2019/12/21 0:57
 */
@RestController
public class ProductAttributeController {
    @Autowired
    private ProductAttributeService productAttributeService;
    @PostMapping("/list")
    public List<ProductAttribute> list(){
        return productAttributeService.getMapper().selectAll();
    }

}
