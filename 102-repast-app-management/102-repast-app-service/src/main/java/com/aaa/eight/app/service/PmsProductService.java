package com.aaa.eight.app.service;


import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.PmsProductMapper;
import com.aaa.eight.app.vo.ShopRecommendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author YYAN
 * @date 2019/12/21 14:12
 * @descriptNo such property: code for class: Script1
 * @return
 */
@Service
public class PmsProductService extends BaseService<ShopRecommendVo> {

    @Override
    public Mapper getMapper() {
        return null;
    }

    @Autowired
    private PmsProductMapper pmsProductMapper;

    /**
     * @auther YYAN
     * @date 2019/12/21 14:13
     * 查询推荐商品
     * @descriptNo such property: code for class: Script1
     * @return
     */
    public List<ShopRecommendVo> selectGetShopId(){
        List<ShopRecommendVo> sale = pmsProductMapper.getSale();
        if(sale.size()>0){
            return sale;
        }
        return sale;
    }



}
