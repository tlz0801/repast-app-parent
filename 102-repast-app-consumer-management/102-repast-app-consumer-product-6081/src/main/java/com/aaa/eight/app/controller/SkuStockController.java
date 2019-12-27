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
 * @Param:库存信息
 * @Date: 2019/12/21 1:07
 */
@RestController
@Api(value = "库存信息",tags = "库存信息接口")
public class SkuStockController extends BaseController {
    @Autowired
    private IRepastService iRepastService;
    @PostMapping("/data")
    @ApiOperation(value = "查询所有",notes = "执行操作")
    public ResultData data(String token){
        if(null==token){
            return getTokenFailed();
        }
        if (iRepastService.data().size()!=0){
            return success(iRepastService.data());
        }
        return failed();
    }

}
