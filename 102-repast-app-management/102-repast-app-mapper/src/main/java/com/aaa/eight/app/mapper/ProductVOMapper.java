package com.aaa.eight.app.mapper;

import com.aaa.eight.app.model.Product;
import com.aaa.eight.app.vo.PageVO;
import com.aaa.eight.app.vo.ProductVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface ProductVOMapper extends Mapper<ProductVO> {

    public List<ProductVO> selectProductById(@Param("productId") Long productId);

    public List<ProductVO> selectProductByKeyword(@Param("keyword") String keyword, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    public Integer count(@Param("keyword")String keyword);

    public List<ProductVO> selectProductByCateInShop(@Param("cateId") Long cateId,@Param("shopId") Long shopId);

}