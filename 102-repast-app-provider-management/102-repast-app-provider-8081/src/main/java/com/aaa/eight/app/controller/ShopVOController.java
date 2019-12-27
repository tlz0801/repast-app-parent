package com.aaa.eight.app.controller;

import com.aaa.eight.app.service.ShopVOService;
import com.aaa.eight.app.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/21 16:03
 **/
@RestController
public class ShopVOController {
    @Autowired
    private ShopVOService shopVOService;

    @PostMapping("/selectShopByShopId")
    public List<ShopVO> selectShopByShopId(@RequestParam("shopId")Long shopId){
        return shopVOService.selectShopByShopId(shopId);
    }
}
