package com.aaa.eight.app.mapper;

import com.aaa.eight.app.model.ShopInformation;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import javax.validation.constraints.Max;
@Repository
public interface ShopInformationMapper extends Mapper<ShopInformation> {
}