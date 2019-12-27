package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.SkuStockMapper;
import com.aaa.eight.app.model.SkuStock;
import com.aaa.eight.app.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: wyy
 * @Param:库存信息
 * @Date: 2019/12/21 0:42
 */
@Service
public class SkuStockService  extends BaseService<SkuStock> {
    @Autowired
    private SkuStockMapper skuStockMapper;
    @Autowired
    private Map<String,Object> hashMap;
    @Override
    public Mapper<SkuStock> getMapper() {
        return skuStockMapper;
    }
    public List<SkuStock> data(){
        List<SkuStock> data = skuStockMapper.selectAll();
        if (null == data){
            hashMap.put("code", StatusEnum.NOT_EXIST.getCode());
            hashMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
        }
        return  data;
    }
}
