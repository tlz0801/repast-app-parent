package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "广告信息" , tags = "广告信息接口")
public class AdvertiseController extends BaseController {

    @Autowired
    private IRepastService iRepastService;

    @PostMapping("/selectAdvertise")
    @ApiOperation(value = "广告信息", notes = "执行查询所有广告信息操作")
    public ResultData selectAdvertise(String token){
        if(null==token){
            return getTokenFailed();
        }
        List<Object> advertise = iRepastService.selectAdvertise();
        if (advertise.size()>0){
            return success(advertise);
        }
        return failed();
    }


}
