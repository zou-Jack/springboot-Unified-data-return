package com.zoutao.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @title: User
 * @Description:  7.用户类用来测试
 * @Param:
 * @return:
 * @Author: ZouTao
 * @Date: 2020/4/15
 */
@Data
@EqualsAndHashCode
public class User implements Serializable {

    private Integer id;

    private String name;
    
}
