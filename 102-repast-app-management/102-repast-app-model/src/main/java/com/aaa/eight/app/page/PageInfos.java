package com.aaa.eight.app.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Project 102-repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/18 21:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageInfos<T> {
    /**
     * 当前页码数
     */
    private Integer pageNum;

    /**
     * 每一页显示条数
     */
    private Integer pageSize;

    /**
     * 所需要返回的数据
     */
    private T t;
}
