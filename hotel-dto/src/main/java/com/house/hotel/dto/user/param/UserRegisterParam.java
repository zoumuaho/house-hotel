package com.house.hotel.dto.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @auhtor muhao.zou
 * @date 2020/9/27 23:11
 */
@ApiModel(value = "用户注册入参")
public class UserRegisterParam implements Serializable {

    private static final long serialVersionUID = -806842181049490814L;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String userName;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String userAccount;

    /**
     * 账户类型 1超级管理员 2门店管理员
     */
    @ApiModelProperty(value = "账户类型 1超级管理员 2门店管理员")
    private Integer accountType;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 所属门店
     */
    @ApiModelProperty(value = "所属门店id")
    private String storeId;

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

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

    public Integer getAccountType() {
        return accountType;
    }

    public UserRegisterParam setAccountType(Integer accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterParam setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStoreId() {
        return storeId;
    }

    public UserRegisterParam setStoreId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public UserRegisterParam setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }
}
