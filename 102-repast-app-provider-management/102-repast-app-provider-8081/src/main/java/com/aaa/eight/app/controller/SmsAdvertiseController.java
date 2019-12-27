package com.aaa.eight.app.controller;

import com.aaa.eight.app.vo.AdvertisePositionVO;
import com.aaa.eight.app.service.RedisService;
import com.aaa.eight.app.service.SmsAdvertisePositionService;
import com.aaa.eight.app.service.SmsAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SmsAdvertiseController {
    @Autowired
    private SmsAdvertiseService smsAdvertiseService;
    @Autowired
    private SmsAdvertisePositionService smsAdvertisePositionService;
    @Autowired
    private RedisService redisService;

    /**
     * 执行查询广告的操作
     */
    @PostMapping("/selectAdvertise")
    public List<AdvertisePositionVO>  selectAdvertise(){
        return smsAdvertisePositionService.selectAdvertionPosition(smsAdvertiseService,redisService);
    }
}
