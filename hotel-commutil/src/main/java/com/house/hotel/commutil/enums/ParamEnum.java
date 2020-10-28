package com.house.hotel.commutil.enums;

import com.house.hotel.commutil.api.IErrorCode;

/**
 * @auhtor muhao.zou
 * @date 2020/9/27 23:10
 */
public enum ParamEnum implements IErrorCode {
    MISSING_NECESSARY_PARAM("90000","缺少别要参数")
    ;
    private String code;
    private String message;


    ParamEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
