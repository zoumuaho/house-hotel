package com.house.hotel.dto.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @auhtor muhao.zou
 * @date 2020/9/27 23:11
 */
@ApiModel(value = "用户注册入参")
public class UserRegisterParam implements Serializable {

    private static final long serialVersionUID = -806842181049490814L;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    private String userName;
    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    private String userAccount;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色id")
    private Integer roleId;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "电子邮箱")
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public UserRegisterParam setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserRegisterParam setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public UserRegisterParam setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterParam setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public UserRegisterParam setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserRegisterParam setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterParam setEmail(String email) {
        this.email = email;
        return this;
    }
}
