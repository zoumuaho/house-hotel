package com.house.hotel.dao.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "hotel_user_info")
public class HotelUserInfo {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 账号
     */
    @Column(name = "user_account")
    private String userAccount;
    /**
     * 账户类型 1超级管理员 2门店管理员
     */
    @Column(name = "account_type")
    private Integer accountType;
    /**
     * 密码
     */
    private String password;

    /**
     * 所属门店
     */
    @Column(name = "store_id")
    private String storeId;

    /**
     * 角色
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 是否有效 0无效 1有效
     */
    private Integer disabled;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改日期
     */
    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 获取主键ID
     *
     * @return user_id - 主键ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置主键ID
     *
     * @param userId 主键ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取账号
     *
     * @return user_account - 账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置账号
     *
     * @param userAccount 账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 账户类型
     * @return
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 设置账户类型
     * @param accountType 账户类型
     * @return
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取所属门店
     *
     * @return store_id - 所属门店
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 设置所属门店
     *
     * @param storeId 所属门店
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取角色
     *
     * @return role_id - 角色
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色
     *
     * @param roleId 角色
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取是否有效 0无效 1有效
     *
     * @return disabled - 是否有效 0无效 1有效
     */
    public Integer getDisabled() {
        return disabled;
    }

    /**
     * 设置是否有效 0无效 1有效
     *
     * @param disabled 是否有效 0无效 1有效
     */
    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改日期
     *
     * @return modify_date - 修改日期
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置修改日期
     *
     * @param modifyDate 修改日期
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
