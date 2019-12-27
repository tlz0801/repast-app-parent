package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import com.aaa.eight.app.model.PmsCommentReplay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "对商品进行评价",tags = "对商品进行评价接口")
public class CommentReplayController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @GetMapping("/insertCommentReplay")
    @ApiOperation(value = "对商品进行评价", notes = "对商品进行评价的接口")
    private ResultData insertCommentReplay(String token,@RequestBody PmsCommentReplay commentReplay){
        if(null==token){
            return getTokenFailed();
        }
        if (repastService.insertCommentReplay(commentReplay)==true){
            return success();
        }else {
            return failed();
        }
    }
}
