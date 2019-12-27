package com.aaa.eight.app.mapper;


import com.aaa.eight.app.vo.CommentInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PmsCommentMapper{

    /**
     * 根据商品id获取商品前十条的评价
     * @param id
     * @return
     */
    List<CommentInfoVo> getCommentById(Long id);

    /**
     * 根据商品id获取商品所有的评价
     * @param id
     * @return
     */
    List<CommentInfoVo> getCommentByIdAll(Long id);


}