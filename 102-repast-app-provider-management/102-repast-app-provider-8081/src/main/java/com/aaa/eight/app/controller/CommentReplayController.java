package com.aaa.eight.app.controller;

import com.aaa.eight.app.model.PmsCommentReplay;
import com.aaa.eight.app.service.CommentReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KANG
 */
@RestController
public class CommentReplayController {
    @Autowired
    private CommentReplayService commentReplayService;

    @PostMapping("/insertCommentReplay")
    public boolean insertCommentReplay(@RequestBody PmsCommentReplay commentReplay){
        boolean insertcommentreplay = commentReplayService.insertcommentreplay(commentReplay);
        return insertcommentreplay;
    }
}
