package com.aaa.eight.app.controller;

import com.aaa.eight.app.vo.CommentInfoVo;
import com.aaa.eight.app.service.CommentInfoVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentInfoVoService commentInfoVoService;

    /**
     * 商品的评论阅读数量前十
     * @param id
     * @return
     */
    @GetMapping("/comments")
    public List<CommentInfoVo> commentById(@RequestParam("id") Long id){
        return commentInfoVoService.getCommentById(id);
    }


    /**
     * 商品的全部评论
     * @param id
     * @return
     */
    @GetMapping("/commentsall")
    public List<CommentInfoVo> commentByIdAll(@RequestParam("id") Long id){
        return commentInfoVoService.getCommentByIdAll(id);
    }
}
