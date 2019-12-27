package com.aaa.eight.app.mapper;

import com.aaa.eight.app.model.Product;
import com.aaa.eight.app.vo.ProductAttributeSkuStockCategoryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface ProductMapper extends Mapper<Product> {

    List<Product> allProduct();
    List<Product> allProductByShopId(@Param("shopId") Long shopId);

    List<ProductAttributeSkuStockCategoryVo> getAll(ProductAttributeSkuStockCategoryVo productAttributeSkuStockCategoryVo);
}