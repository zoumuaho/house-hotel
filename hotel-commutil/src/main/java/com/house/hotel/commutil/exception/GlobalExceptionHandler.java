package com.house.hotel.commutil.exception;

import com.house.hotel.commutil.api.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @auhtor muhao.zou
 * @date 2020/9/27 22:56
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public BaseResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return BaseResult.failed(e.getErrorCode());
        }
        return BaseResult.failed(e.getMessage());
    }
}
