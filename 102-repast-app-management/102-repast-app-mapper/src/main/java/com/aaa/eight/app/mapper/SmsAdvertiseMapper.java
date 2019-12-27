package com.aaa.eight.app.mapper;

import com.aaa.eight.app.vo.AdvertisePositionVO;
import com.aaa.eight.app.model.SmsAdvertise;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface SmsAdvertiseMapper extends Mapper<SmsAdvertise> {
    /**
     * 根据广告位置表的id和该位置最多放置的广告数量，查询每个广告位置的广告信息
     * @param positionId
     * @param maxCount
     * @return
     */
    List<AdvertisePositionVO> selectSmsAdvertise(@Param("positionId") Long positionId, @Param("maxCount") Integer maxCount);
}