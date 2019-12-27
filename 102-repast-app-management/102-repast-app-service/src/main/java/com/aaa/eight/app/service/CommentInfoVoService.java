package com.aaa.eight.app.service;

import com.aaa.eight.app.vo.CommentInfoVo;
import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.PmsCommentMapper;
import com.aaa.eight.app.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Service
public class CommentInfoVoService extends BaseService<CommentInfoVo> {
    @Value("product_detailc")
    private String productDetailc;

    @Override
    public Mapper<CommentInfoVo> getMapper() {
        return null;
    }

    @Autowired
    private PmsCommentMapper pmsCommentMapper;

    @Autowired
    private Map<String, Object> resultMap;

    /**
     * 通过商品id获取商品评论的前十
     * @param id
     * @param
     * @return
     */
    public List<CommentInfoVo> getCommentById(Long id){
            //到MySql中查询数据
            List<CommentInfoVo> commentById = pmsCommentMapper.getCommentById(id);
            //判断是否拿到数据
            if (commentById.size()==0) {
                resultMap.put("code", StatusEnum.NOT_EXIST.getCode());
                resultMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
                resultMap.put("data",commentById);
            }
            return commentById;
    }

    /**
     * 通过商品id获取商品的所有评论
     * @param id
     * @return
     */
    public List<CommentInfoVo>getCommentByIdAll(Long id){
        //到MySql中查询数据
        List<CommentInfoVo> commentByIdAll = pmsCommentMapper.getCommentByIdAll(id);
        //判断是否拿到数据
        if (commentByIdAll.size()==0) {
            resultMap.put("code", StatusEnum.NOT_EXIST.getCode());
            resultMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
            resultMap.put("data",commentByIdAll);
        }
        return commentByIdAll;

    }


}
