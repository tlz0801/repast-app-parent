package com.aaa.eight.app.controller;

import com.aaa.eight.app.model.SkuStock;
import com.aaa.eight.app.service.SkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wyy
 * @Param:库存信息
 * @Date: 2019/12/21 0:39
 */
@RestController
public class SkuStockController {
    @Autowired
    private SkuStockService skuStockService;
    @PostMapping("/data")
    public List<SkuStock> data(){
        return skuStockService.getMapper().selectAll();
    }
}
