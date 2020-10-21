package com.house.hotel.commutil.enums;

import com.house.hotel.commutil.api.IErrorCode;

/**
 * @auhtor muhao.zou
 * @date 2020/10/21 21:01
 */
public enum  HotelUserOperationEnum implements IErrorCode {
    SAVE_USER_EXCEPTION("10000","保存用户信息失败"),
    SAVE_USER_PARAM_NOT_EXIST("10001","缺少必要参数")

    ;
    private String code;
    private String message;

    HotelUserOperationEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public HotelUserOperationEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public HotelUserOperationEnum setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
