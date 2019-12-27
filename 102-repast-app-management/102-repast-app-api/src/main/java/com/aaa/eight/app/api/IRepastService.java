package com.aaa.eight.app.api;

import com.aaa.eight.app.fallback.RepastFallback;
import com.aaa.eight.app.model.*;
import com.aaa.eight.app.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 11:34
 **/
@FeignClient(value = "product-interface-provider", fallbackFactory = RepastFallback.class)
public interface IRepastService {

    /**
     * 查询所有商品单表信息
     * @return
     */
    @PostMapping("/allProduct")
    List<Product> allProduct();

    /**
     * 查询某店铺的所有商品
     * @param shopId
     * @return
     */
    @PostMapping("/allProductByShopId")
    List<Product> allProductByShopId(@RequestParam("shopId") Long shopId);

    /**
     * 根据商店ID查询商店详情
     * @param shopId
     * @return
     */
    @PostMapping("/selectShopByShopId")
    List<ShopVO> selectShopByShopId(@RequestParam("shopId") Long shopId);

    /**
     * 根据ID查询商品详情
     * @param productId
     * @return
     */
    @PostMapping("/selectProductById")
    List<ProductVO> selectProductById(@RequestParam("productId")Long productId);

    /**
     * 根据关键字查询分页商品信息
     * @param keyword
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("/selectProductByKeyword")
    List<PageVO> selectProductByKeyword(@RequestParam("keyword")String keyword, @RequestParam("currentPage")Integer currentPage, @RequestParam("pageSize")Integer pageSize);

    /**
     * 查询某商店某类全部商品
     * @param cateId
     * @param shopId
     * @return
     */
    @PostMapping("/selectProductByCateInShop")
    List<ProductVO> selectProductByCateInShop(@RequestParam("cateId")Long cateId,@RequestParam("shopId")Long shopId);


    /**
     * @auther YYAN
     * 商品推荐熔断数据
     * @date 2019/12/21 14:18
     * @descriptNo such property: code for class: Script1
     * @return
     */
    @PostMapping("/shop")
    public List<ShopRecommendVo> ShopRecommend();

    /**
     * 广告位
     */
    @PostMapping("/selectAdvertise")
    List<Object> selectAdvertise();

    /**
     * 根据商品id获取商品的评价
     * @param id
     * @return
     */
    @GetMapping("/comments")
    List<CommentInfoVo> commentById(@RequestParam("id") Long id);

    /**
     * 根据商品id获取商品全部的评价
     * @param id
     * @return
     */
    @GetMapping("/commentsall")
    List<CommentInfoVo> commentByIdAll(@RequestParam("id") Long id);

    /**
     * 对商品进行评价
     * @param commentReplay
     * @return
     */
    @PostMapping("/insertCommentReplay")
    boolean insertCommentReplay(@RequestBody PmsCommentReplay commentReplay);

    @PostMapping("/all")
    List<Product> all();
    @PostMapping("/list")
    List<ProductAttribute> list();
    @PostMapping("/data")
    List<SkuStock> data();
    @PostMapping("/getAll")
    List<ProductAttributeSkuStockCategoryVo> getAll( ProductAttributeSkuStockCategoryVo productAttributeSkuStockCategoryVo);
    @PostMapping("/listAll")
    List<ProductCategory> listAll();
}
