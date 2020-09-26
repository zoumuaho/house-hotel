package com.house.hotel.dto.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 12:49
 */
@ApiModel(value = "用户信息出参模型")
public class HotelUserInfoModel implements Serializable {

    private static final long serialVersionUID = 6024528684940258454L;
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long userId;

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
     * 账户类型
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
    @ApiModelProperty(value = "所属门店")
    private String storeId;

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色")
    private Integer roleId;

    /**
     * 是否有效 0无效 1有效
     */
    @ApiModelProperty(value = "是否有效 0无效 1有效")
    private Integer disabled;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remark;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Date createDate;

    /**
     * 修改日期
     */
    @ApiModelProperty(value = "修改日期")
    private Date modifyDate;


    public Long getUserId() {
        return userId;
    }

    public HotelUserInfoModel setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public HotelUserInfoModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public HotelUserInfoModel setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public HotelUserInfoModel setAccountType(Integer accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public HotelUserInfoModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStoreId() {
        return storeId;
    }

    public HotelUserInfoModel setStoreId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public HotelUserInfoModel setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public HotelUserInfoModel setDisabled(Integer disabled) {
        this.disabled = disabled;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public HotelUserInfoModel setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public HotelUserInfoModel setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public HotelUserInfoModel setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    @Override
    public String toString() {
        return "HotelUserInfoModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", accountType=" + accountType +
                ", password='" + password + '\'' +
                ", storeId='" + storeId + '\'' +
                ", roleId=" + roleId +
                ", disabled=" + disabled +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
