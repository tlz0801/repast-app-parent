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
 * @Param:
 * @Date: 2019/12/21 1:12
 */
@RestController
@Api(value = "商品属性",tags = "商品属性接口")
public class ProductAttributeController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    @PostMapping("/list")
    @ApiOperation(value = "查询所有",notes = "执行操作")
    public ResultData list(String token){
        if(null==token){
            return getTokenFailed();
        }
        if (iRepastService.list().size()!=0){
            return success(iRepastService.list());
        }
        return failed();
    }
}
