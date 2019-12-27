package com.aaa.eight.app.fallback;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.model.*;
import com.aaa.eight.app.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 11:35
 **/
@Component
public class RepastFallback implements FallbackFactory<IRepastService> {
    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService(){

            @Override
            public List<Product> allProduct() {
                System.out.println("测试查询商品单表信息熔断数据");
                return null;
            }

            @Override
            public List<Product> allProductByShopId(Long shopId) {
                System.out.println("测试查询店铺所有商品熔断数据");
                return null;
            }

            @Override
            public List<ShopVO> selectShopByShopId(Long shopId) {
                System.out.println("测试查询店铺信息熔断数据");
                return null;
            }

            @Override
            public List<ProductVO> selectProductById(Long productId) {
                System.out.println("测试查询商品综合信息熔断数据");
                return null;
            }

            @Override
            public List<PageVO> selectProductByKeyword(String keyword, Integer currentPage, Integer pageSize) {
                System.out.println("测试根据关键字查询商品综合信息熔断数据");
                return null;
            }

            @Override
            public List<ProductVO> selectProductByCateInShop(Long cateId, Long shopId) {
                System.out.println("测试查询某店铺的某一类商品信息熔断数据");
                return null;
            }


            /**
             * @auther YYAN
             * 商品推荐熔断方法
             * @date 2019/12/21 14:20
             * @descriptNo such property: code for class: Script1
             * @return com.aaa.eight.app.api.IRepastService
             */
            @Override
            public List<ShopRecommendVo> ShopRecommend() {
                System.out.println("商品熔断测试推荐");
                return null;
            }


            @Override
            public List<Object> selectAdvertise() {
                System.out.println("测试广告查询熔断数据");
                return null;
            }

            @Override
            public List<CommentInfoVo> commentById(Long id) {
                System.out.println("测试商品前十评价熔断数据");
                return null;
            }

            @Override
            public List<CommentInfoVo> commentByIdAll(Long id) {
                System.out.println("测试商品全部评价熔断数据");
                return null;
            }

            @Override
            public boolean insertCommentReplay(PmsCommentReplay commentReplay) {
                System.out.println("测试对商品进行评价熔断数据");
                return false;
            }


            @Override
            public List<Product> all() {
                System.out.println("测试查询熔断数据");
                return null;
            }

            @Override
            public List<ProductAttribute> list() {
                System.out.println("测试查询熔断数据");
                return null;
            }

            @Override
            public List<SkuStock> data() {
                System.out.println("测试查询熔断数据");
                return null;
            }

            @Override
            public List<ProductAttributeSkuStockCategoryVo> getAll(ProductAttributeSkuStockCategoryVo productAttributeSkuStockCategoryVo) {
                System.out.println("测试查询熔断数据");
                return null;
            }

            @Override
            public List<ProductCategory> listAll() {
                System.out.println("测试查询熔断数据");
                return null;
            }
        };
        return repastService;
    }
}
