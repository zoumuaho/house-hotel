package com.house.hotel.dto;

import com.house.hotel.dto.user.ResultCode;
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
     * 状态码
     */
    @ApiModelProperty(value = "响应状态码")
    private String code;
    /**
     * 响应信息
     */
    @ApiModelProperty(value = "响应信息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据列表")
    private T data;


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> BaseResult<T> success(T data, String message) {
        return new BaseResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> BaseResult<T> failed(IErrorCode errorCode) {
        return new BaseResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> BaseResult<T> failed(IErrorCode errorCode,String message) {
        return new BaseResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> BaseResult<T> failed(String message) {
        return new BaseResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> BaseResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> BaseResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> BaseResult<T> validateFailed(String message) {
        return new BaseResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> BaseResult<T> unauthorized(T data) {
        return new BaseResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> BaseResult<T> forbidden(T data) {
        return new BaseResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public BaseResult() {
    }

    public BaseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
