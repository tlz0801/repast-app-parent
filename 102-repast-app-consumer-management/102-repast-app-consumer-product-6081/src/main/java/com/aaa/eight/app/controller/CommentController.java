package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KANG
 */
@RestController
@Api(value = "商品评价",tags = "商品评价接口")
public class CommentController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @GetMapping("/comments")
    @ApiOperation(value = "商品评价前十条", notes = "通过id获取商品评价前十条")
    private ResultData commentById(String token,@RequestParam Long id){
        if(null==token){
            return getTokenFailed();
        }
        if (repastService.commentById(id).size()>0){
            return success(repastService.commentById(id));
        }else {
            return failed();
        }
    }


    @GetMapping("/commentsall")
    @ApiOperation(value = "商品全部评价", notes = "通过id获取商品全部评价")
    private ResultData commentByIdAll(String token,Long id){
        if(null==token){
            return getTokenFailed();
        }
        if (repastService.commentById(id).size()>0){
            return success(repastService.commentByIdAll(id));
        }else {
            return failed();
        }
    }
}
