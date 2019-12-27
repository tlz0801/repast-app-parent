package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ShopInformationMapper;
import com.aaa.eight.app.model.Product;
import com.aaa.eight.app.model.ShopInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/21 14:41
 **/
@Service
public class ShopService extends BaseService<ShopInformation> {
    @Autowired
    private ShopInformationMapper shopInformationMapper;
    @Override
    public Mapper<ShopInformation> getMapper() {
        return shopInformationMapper;
    }
}
