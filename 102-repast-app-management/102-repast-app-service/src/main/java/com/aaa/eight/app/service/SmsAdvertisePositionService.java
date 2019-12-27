package com.aaa.eight.app.service;

import com.aaa.eight.app.vo.AdvertisePositionVO;
import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.SmsAdvertisePositionMapper;
import com.aaa.eight.app.model.SmsAdvertisePosition;
import com.aaa.eight.app.staticproperties.StaticProperties;
import com.aaa.eight.app.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 广告位位置表的service
 */
@Service
public class SmsAdvertisePositionService extends BaseService<SmsAdvertisePosition> {

    @Autowired
    private SmsAdvertisePositionMapper smsAdvertisePositionMapper;

    private String adverKey="advertisePositionVOKey";

    /**
     * 查询广告位置信息的广告信息
     * @param smsAdvertiseService
     * @return
     */
    public List<AdvertisePositionVO> selectAdvertionPosition(SmsAdvertiseService smsAdvertiseService, RedisService redisService) {
        // 查询判断redis中是否已经存在数据信息
        String advertisePositionRedis = redisService.get(adverKey);
        if (null != advertisePositionRedis && !("").equals(advertisePositionRedis)) {
            return JSONUtil.toList(advertisePositionRedis, AdvertisePositionVO.class);
        } else {
            // reids中没有数据查询数据库中的数据，并存到redis中
            try {
                // 查询广告位置信息
                List<SmsAdvertisePosition> smsAdvertisePositions = super.selectAll();
                if (smsAdvertisePositions.size() > 0) {
                    for (SmsAdvertisePosition smsAdvertisePosition : smsAdvertisePositions) {
                        // 广告位id
                        Long positionId = smsAdvertisePosition.getId();
                        // 广告位最大播放的次数
                        Integer maxCount = smsAdvertisePosition.getMaxCount();
                        // 通过id，最大次数查询所有的广告
                        List<AdvertisePositionVO> advertisePositionVOS = smsAdvertiseService.select(positionId, maxCount);
                        if (advertisePositionVOS.size() > 0) {
                            // 查询有值后，数据转换，并存到redis中
                            String advertisePositionVOSValue = JSONUtil.toJsonString(advertisePositionVOS);
                            String set = redisService.set(adverKey, advertisePositionVOSValue);
                            if (StaticProperties.OK.equals(set)) {
                                return advertisePositionVOS;
                            }
                        } else {
                            // 广告表中查不到数据
                            return null;
                        }
                    }
                } else {
                    // 广告位置查不到数据
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 通用mapper的相关方法
     * @return
     */
    @Override
    public Mapper<SmsAdvertisePosition> getMapper() {
        return smsAdvertisePositionMapper;
    }
}
