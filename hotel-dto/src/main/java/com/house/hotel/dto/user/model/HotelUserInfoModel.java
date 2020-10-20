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
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;
    /**
     * 电子邮箱
     */
    @ApiModelProperty(value = "电子邮箱")
    private String email;

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

    public String getRoleName() {
        return roleName;
    }

    public HotelUserInfoModel setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public HotelUserInfoModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public HotelUserInfoModel setEmail(String email) {
        this.email = email;
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


}
