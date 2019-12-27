package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ShopVOMapper;
import com.aaa.eight.app.vo.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/21 15:57
 **/
@Service
public class ShopVOService extends BaseService<ShopVO> {
    @Autowired
    private ShopVOMapper shopVOMapper;
    @Override
    public Mapper<ShopVO> getMapper() {
        return shopVOMapper;
    }

    public List<ShopVO> selectShopByShopId(@RequestParam("shopId")Long shopId){
        return shopVOMapper.selectShopByShopId(shopId);
    }


}
