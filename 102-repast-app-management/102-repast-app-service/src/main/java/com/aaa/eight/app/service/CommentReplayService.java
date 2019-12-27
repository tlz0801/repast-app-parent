package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.PmsCommentReplayMapper;
import com.aaa.eight.app.model.PmsCommentReplay;
import com.aaa.eight.app.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * @author KANG
 */
@Service
public class CommentReplayService extends BaseService<PmsCommentReplay> {
    @Autowired
    private PmsCommentReplayMapper pmsCommentReplayMapper;

    @Autowired
    private Map<String, Object> resultMap;

    @Override
    public Mapper<PmsCommentReplay> getMapper() {
        return pmsCommentReplayMapper;
    }

    public boolean insertcommentreplay(PmsCommentReplay commentReplay){
        int insert = pmsCommentReplayMapper.insert(commentReplay);
        if (insert>0){
            resultMap.put("code", StatusEnum.SUCCESS.getCode());
            resultMap.put("msg", StatusEnum.SUCCESS.getMsg());
            resultMap.put("data",insert);
            return true;
        }else {
            resultMap.put("code", StatusEnum.FAILED.getCode());
            resultMap.put("msg", StatusEnum.FAILED.getMsg());
            resultMap.put("data",insert);
            return false;
        }
    }
}
