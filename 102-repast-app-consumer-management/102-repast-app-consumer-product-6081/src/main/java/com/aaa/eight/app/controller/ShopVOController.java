package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/21 16:07
 **/
@RestController
@Api(value = "店铺信息", tags = "店铺信息接口")
public class ShopVOController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @PostMapping("/selectShopByShopId")
    @ApiOperation(value = "查询店铺信息", notes = "执行查询店铺信息的操作")
    public ResultData selectShopByShopId(String token, @RequestParam("shopId")Long shopId){
        if(null==token){
            return getTokenFailed();
        }
        if (0 != repastService.selectShopByShopId(shopId).size()){
            return success(repastService.selectShopByShopId(shopId));
        }
        return failed();
    }
}
