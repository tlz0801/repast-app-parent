package com.aaa.eight.app.controller;

import com.aaa.eight.app.model.ProductCategory;
import com.aaa.eight.app.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wyy
 * @Param:
 * @Date: 2019/12/23 16:21
 */
@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @PostMapping("/listAll")
    public List<ProductCategory> listAll(){
        return productCategoryService.getMapper().selectAll();
    }
}
