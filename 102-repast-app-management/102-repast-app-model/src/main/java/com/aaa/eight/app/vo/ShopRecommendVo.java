package com.aaa.eight.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ProjectName: repast-app-parent
 * @Package: com.aaa.eight.app.vo
 * @ClassName: ShopRecommendVo
 * @Data                    //所有的get set 方法
 * @AllArgsConstructor      //所有的有参构造方法
 * @NoArgsConstructor       //无参构造方法
 * @Accessors(chain = true) //链式调用
 * @Author: YYAN
 * @Description:
 * @Date:
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopRecommendVo implements Serializable {

    //店铺id
    private Long shop_id;
    //产品id
    private Long id;
    //产品名称
    private String name;
    //推荐状态
    private String recommand_status;
    //排序
    private Integer sort;
    //销量
    private Integer sale;
    //商品图片
    private String pic;
}
