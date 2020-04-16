package com.zoutao.web.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title: BaseResponse
 * @Description:  2.统一响应注解--自定义注解。
 * 添加注解后，统一响应体才能生效
 * @Author: ZouTao
 * @Date: 2020/4/15
 */
@Retention(RetentionPolicy.RUNTIME)  //运行时生效
@Target({ElementType.METHOD, ElementType.TYPE}) // 用于描述注解的使用范围
public @interface BaseResponse {

}
