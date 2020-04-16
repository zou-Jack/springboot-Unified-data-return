package com.zoutao.web.exception;

import com.zoutao.web.response.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: BaseException
 * @Description:  4.业务异常类，继承运行异常，确保事务正常回滚
 * @Author: ZouTao
 * @Date: 2020/4/15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException{

    private ResponseCode code;  // 枚举对象

    public BaseException(ResponseCode code) {
        this.code = code;
    }

    public BaseException(Throwable cause, ResponseCode code) {
        super(cause);
        this.code = code;
    }
}
