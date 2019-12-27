package com.aaa.eight.app.service;

import com.aaa.eight.app.vo.AdvertisePositionVO;
import com.aaa.eight.app.mapper.SmsAdvertiseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 广告表是service
 */
@Repository
public class SmsAdvertiseService{

    @Autowired
    private SmsAdvertiseMapper smsAdvertiseMapper;

    /**
     * 根据广告位置的id和位置的数据查询广告表
     * @param positionId
     * @param maxCount
     * @return
     */
    public List<AdvertisePositionVO> select(Long positionId, Integer maxCount) {
        List<AdvertisePositionVO> advertisePositionVOS = smsAdvertiseMapper.selectSmsAdvertise(positionId, maxCount);
        if (advertisePositionVOS.size() > 0) {
            return advertisePositionVOS;
        }
        return null;
    }

}
