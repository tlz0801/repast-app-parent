package com.aaa.eight.app.controller;

import com.aaa.eight.app.vo.CommentInfoVo;
import com.aaa.eight.app.service.CommentInfoVoService;
import com.aaa.eight.app.service.CommentReplayService;
import com.aaa.eight.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PmsCommentController {

    @Autowired
    private CommentInfoVoService commentInfoVoService;
    @Autowired
    private CommentReplayService commentReplayService;
    @Autowired
    private RedisService redisService;

    /**
     * 执行查询广告的操作
     */
    @PostMapping("/selectComment")
    public List<CommentInfoVo>  selectAdvertise(){
        return null;
    }
}
