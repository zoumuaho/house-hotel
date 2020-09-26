package com.house.hotel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 15:22
 */
@ApiModel(value = "DTO模型超类型")
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 7678842667786557779L;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据列表")
    private Object data;
    /**
     * 状态码
     */
    @ApiModelProperty(value = "响应状态码")
    private String code;
    /**
     * 响应信息
     */
    @ApiModelProperty(value = "响应信息")
    private String message;


    public BaseResult() {

    }

    public BaseResult(Object data) {
        this.data = data;
    }

    public BaseResult(Object data, String code) {
        this.data = data;
        this.code = code;
    }

    public BaseResult(Object data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public BaseResult setData(Object data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public BaseResult setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResult setMessage(String message) {
        this.message = message;
        return this;
    }
}
