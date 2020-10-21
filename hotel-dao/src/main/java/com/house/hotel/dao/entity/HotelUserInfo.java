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
    @GeneratedValue(generator = "JDBC")
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
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;
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

    public Long getUserId() {
        return userId;
    }

    public HotelUserInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public HotelUserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public HotelUserInfo setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }



    public String getPassword() {
        return password;
    }

    public HotelUserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public HotelUserInfo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public HotelUserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public HotelUserInfo setDisabled(Integer disabled) {
        this.disabled = disabled;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public HotelUserInfo setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public HotelUserInfo setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public HotelUserInfo setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }
}
