package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import com.aaa.eight.app.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 11:26
 **/
@RestController
@Api(value = "商品信息", tags = "商品信息接口")
public class ProductController extends BaseController {

    @Autowired
    private IRepastService repastService;



    @PostMapping("/allProduct")
    @ApiOperation(value = "查询全部", notes = "执行查询全部的操作")
    public ResultData allProduct(String token) {
        if(null==token){
            return getTokenFailed();
        }
        if(0 != repastService.allProduct().size()) {
            return success(repastService.allProduct());
        }
        return failed();
    }

    @PostMapping("/allProductByShopId")
    @ApiOperation(value = "根据店铺ID查询店铺的全部商品", notes = "执行根据店铺ID查询店铺全部商品的操作")
    public ResultData allProductByShopId(String token, @RequestParam("shopId") Long shopId){
        if(null==token){
            return getTokenFailed();
        }
        List<Product> productList = repastService.allProductByShopId(shopId);
        if (!"".equals(productList)){
            return success(productList);
        }
        return failed();
    }


    @PostMapping("/all")
    @ApiOperation(value = "查询所有",notes = "执行操作")
    public ResultData all(String token){
        if(null==token){
            return getTokenFailed();
        }
        if (repastService.all().size()!=0){
            return success(repastService.all());
        }
        return failed();
    }
}
