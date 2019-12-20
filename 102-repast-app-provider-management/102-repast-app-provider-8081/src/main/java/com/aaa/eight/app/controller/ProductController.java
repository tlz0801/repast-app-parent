package com.aaa.eight.app.controller;

import com.aaa.eight.app.model.Product;
import com.aaa.eight.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 10:45
 **/
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/allProduct")
    public List<Product> allProduct() {
        return productService.getMapper().selectAll();
    }

}
