package com.house.hotel.dto.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 15:49
 */
@ApiModel(value = "用户登录入参")
public class UserLoginParam implements Serializable {

    private static final long serialVersionUID = -8790524898182125093L;

    @ApiModelProperty("用户账号")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginParam setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginParam setPassword(String password) {
        this.password = password;
        return this;
    }
}
