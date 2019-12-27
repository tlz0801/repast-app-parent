package com.aaa.eight.app.controller;

import com.aaa.eight.app.service.ProductAttributeSkuStockCategoryVoService;
import com.aaa.eight.app.vo.ProductAttributeSkuStockCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wyy
 * @Param:
 * @Date: 2019/12/23 14:52
 */
@RestController
public class ProductAttributeSkuStockCategoryVoController {
    @Autowired
    private ProductAttributeSkuStockCategoryVoService productAttributeSkuStockCategoryVoService;
    @RequestMapping("/getAll")
    public List<ProductAttributeSkuStockCategoryVo> getAll(@RequestBody ProductAttributeSkuStockCategoryVo productAttributeSkuStockCategoryVo){
        return productAttributeSkuStockCategoryVoService.getAll(productAttributeSkuStockCategoryVo);
    }
}
