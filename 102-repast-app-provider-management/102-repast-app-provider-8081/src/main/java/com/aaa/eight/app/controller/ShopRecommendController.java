package com.aaa.eight.app.controller;

import com.aaa.eight.app.service.PmsProductService;
import com.aaa.eight.app.vo.ShopRecommendVo;
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
public class ShopRecommendController {

    @Autowired
    private PmsProductService pmsProductService;

    @PostMapping("/shop")
    public List<ShopRecommendVo> ShopRecommend(){
        return pmsProductService.selectGetShopId();
    }
}
