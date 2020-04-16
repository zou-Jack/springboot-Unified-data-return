package com.zoutao.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @title: ResponseResult
 * @Description:  1.统一的公共响应体（统一结果类）
 * @Author: ZouTao
 * @Date: 2020/4/15
 */
@Data
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的信息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;

}
