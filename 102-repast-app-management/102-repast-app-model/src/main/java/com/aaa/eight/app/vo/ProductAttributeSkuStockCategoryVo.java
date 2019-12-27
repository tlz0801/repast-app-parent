package com.aaa.eight.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: wyy
 * @Param:
 * @Date: 2019/12/21 10:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductAttributeSkuStockCategoryVo implements Serializable {
    private Long id;
    private Long shop_id;
    private String name;
    private Long brand_id;
    private Long product_category_id;
    private String  product_sn;
    private String publish_status;
    private String new_Status;
    private String recommand_status;
    private Long sale;
    private String price;
    private String promotion_price;
    private String gift_point;
    private String sub_title;
    private String description;
    private String original_price;
    private Long stock;
    private String service_ids;
    private String note;
    private Long album_id;
    private String detail_title;
    private String detail_html;
    private String detail_mobile_html;
    private String promotion_start_time;
    private String promotion_end_time;
    private String promotion_per_limit;
    private String promotion_type;
    private String brand_name;
    private String product_category_name;
    private String currency;
    private Long product_attribute_category_id;
    private String select_type;
    private String type;
    private Long product_id;
    private String sku_code;
    private Long parent_id;
    private String level;
    private String icon;





}
