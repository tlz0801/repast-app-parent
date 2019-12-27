package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import com.aaa.eight.app.vo.ShopRecommendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: repast-app-parent
 * @Package: com.aaa.eight.app.controller
 * @ClassName: ShopRecommendController
 * @Author: YYAN
 * @Description:
 * @Date:
 * @Version: 1.0
 */
@RestController
@Api(value = "商品推荐", tags = "商品推荐接口")
public class ShopRecommendController extends BaseController {

    @Autowired
    private IRepastService repastService;

    @PostMapping("/shop")
    @ApiOperation(value = "商品推荐", notes = "执行商品推荐操作")
    public ResultData ShopRecommend(String token){
        if(null==token){
            return getTokenFailed();
        }
        List<ShopRecommendVo> shopRecommendVos = repastService.ShopRecommend();
        if(shopRecommendVos.size()>0){
            return success(shopRecommendVos);
        }
        return failed();
    }
}
