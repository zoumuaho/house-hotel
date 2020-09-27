package com.house.hotel.webapi.config;

import com.house.hotel.commutil.api.BaseResult;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 13:04
 * 统一返回对象
 */
public class BaseResultUtil {

    private static final String SUCCESS_MESSAGE = "SUCCESS";

    private static final String SUCCESS_COED = "200";

    public static BaseResult success() {
        return success(null);
    }

    public static BaseResult success(Object object) {
        BaseResult resultVO = new BaseResult();
        resultVO.setData(object);
        resultVO.setCode(SUCCESS_COED);
        resultVO.setMessage(SUCCESS_MESSAGE);
        return resultVO;
    }

    public static BaseResult error(String code, String msg) {
        BaseResult resultVO = new BaseResult();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
