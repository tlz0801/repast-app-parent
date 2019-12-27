package com.aaa.eight.app.mapper;

import com.aaa.eight.app.model.PmsProduct;
import com.aaa.eight.app.vo.ShopRecommendVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author YYAN
 */
@Repository
public interface PmsProductMapper extends Mapper<PmsProduct> {

    /**
     * @auther YYAN
     * @date 2019/12/22 14:23
     * 查询推荐商品
     * @descriptNo such property: code for class: Script1
     * @return
     */
    List<ShopRecommendVo> getSale();
}