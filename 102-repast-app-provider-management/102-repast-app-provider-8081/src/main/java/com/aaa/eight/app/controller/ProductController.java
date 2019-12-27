package com.aaa.eight.app.controller;

import com.aaa.eight.app.model.Product;
import com.aaa.eight.app.service.ProductService;
import com.aaa.eight.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 10:45
 **/
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/allProduct")
    public List<Product> allProduct() {
        return productService.allProduct();
    }
    @PostMapping("/allProductByShopId")
    public List<Product> allProductByShopId(@RequestParam("shopId") Long shopId){
        return productService.allProductByShopId(redisService,shopId);
    }

    @PostMapping("/all")
    public List<Product> all(){
        try {
            return productService.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
