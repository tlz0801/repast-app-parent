package com.aaa.eight.app.mapper;


import com.aaa.eight.app.vo.ShopVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface ShopVOMapper extends Mapper<ShopVO> {
    List<ShopVO> selectShopByShopId(@Param("shopId") Long shopId);
}