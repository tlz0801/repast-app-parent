package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wyy
 * @Param:商品分类
 * @Date: 2019/12/23 16:30
 */
@RestController
@Api(value = "商品分类",tags = "商品分类接口")
public class ProductCategoryController extends BaseController {

    @Autowired
    private IRepastService iRepastService;
    @PostMapping("/listAll")
    @ApiOperation(value = "查询分类",notes = "执行操作")
    public ResultData listAll(String token){
        if(null==token){
            return getTokenFailed();
        }
        if (iRepastService.listAll().size()!=0){
            return success(iRepastService.listAll());
        }
        return failed();
    }

}
