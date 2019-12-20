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
    public ResultData allProduct() {
        if(0 != repastService.allProduct().size()) {
            return success(repastService.allProduct());
        }
        return failed();
    }
}
