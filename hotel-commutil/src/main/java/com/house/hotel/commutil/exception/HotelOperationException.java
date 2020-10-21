package com.house.hotel.commutil.exception;

import com.house.hotel.commutil.api.IErrorCode;
import com.house.hotel.commutil.enums.HotelUserOperationEnum;

/**
 * @auhtor muhao.zou
 * @date 2020/10/21 21:00
 */
public class HotelOperationException  extends RuntimeException {

    private IErrorCode errorCode;

    public HotelOperationException(String message) {
        super(message);
    }

    public HotelOperationException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HotelOperationException(Throwable cause) {
        super(cause);
    }

    public HotelOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
