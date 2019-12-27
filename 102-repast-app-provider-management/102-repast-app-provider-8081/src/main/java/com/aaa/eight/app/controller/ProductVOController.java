package com.aaa.eight.app.controller;

import com.aaa.eight.app.service.ProductVOService;
import com.aaa.eight.app.service.RedisService;
import com.aaa.eight.app.vo.PageVO;
import com.aaa.eight.app.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/23 16:04
 **/
@RestController
public class ProductVOController {
    @Autowired
    private ProductVOService productVOService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/selectProductById")
    public List<ProductVO> selectProductById(@RequestParam("productId")Long productId){
        return productVOService.selectProductById(redisService,productId);
    }
    @PostMapping("/selectProductByKeyword")
    public List<PageVO> selectProductByKeyword(@RequestParam("keyword")String keyword, @RequestParam("currentPage")Integer currentPage, @RequestParam("pageSize")Integer pageSize){
        return productVOService.selectProductByKeyword(keyword,currentPage,pageSize);
    }

    @PostMapping("/selectProductByCateInShop")
    public List<ProductVO> selectProductByCateInShop(@RequestParam("cateId")Long cateId,@RequestParam("shopId")Long shopId){
        return productVOService.selectProductByCateInShop(redisService,cateId,shopId);
    }
}
