package com.zoutao.web.response;

import com.zoutao.web.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @title: ExceptionHandlerAdvice
 * @Description:  5.异常处理器
 * 用于处理Controller中所有运行时未捕获到的异常的处理类。
 * @Author: ZouTao
 * @Date: 2020/4/15
 */
@ControllerAdvice(annotations = BaseResponse.class)
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     * data:null
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e){
        log.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg(),null);
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行异常
     * @return 统一响应体
     * data:null
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg(),null);
    }

    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     * data:null
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e){
        log.error(e.getMessage(),e);
        ResponseCode code=e.getCode();
        return new ResponseResult(code.getCode(),code.getMsg(),null);
    }
}
