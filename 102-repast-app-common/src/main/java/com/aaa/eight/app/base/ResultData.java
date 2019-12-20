package com.aaa.eight.app.base;

import lombok.*;

/**
 * @Project 102-repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/18 19:19
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ResultData<T> {

    private String code;
    private String msg;
    private String detail;
    private T data;

}
