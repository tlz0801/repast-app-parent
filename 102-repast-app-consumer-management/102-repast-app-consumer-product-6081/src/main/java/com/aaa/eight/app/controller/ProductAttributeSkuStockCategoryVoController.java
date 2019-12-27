package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import com.aaa.eight.app.vo.ProductAttributeSkuStockCategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wyy
 * @Param:商品详情
 * @Date: 2019/12/23 14:56
 */
@RestController
@Api(value = "商品详情",tags = "商品多表详情接口")
public class ProductAttributeSkuStockCategoryVoController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    @PostMapping("/getAll")
    @ApiOperation(value ="查询所有",notes = "执行操作")
    public ResultData getAll(String token,ProductAttributeSkuStockCategoryVo productAttributeSkuStockCategoryVo){
        if(null==token){
            return getTokenFailed();
        }
        if (iRepastService.getAll(productAttributeSkuStockCategoryVo).size()!=0){
            return success(iRepastService.getAll(productAttributeSkuStockCategoryVo));
        }
        return failed();
    }
}
