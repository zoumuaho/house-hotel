package com.house.hotel.dao.model;

import com.house.hotel.dao.entity.HotelRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/30 17:28
 */
public class HotelUserInfoConverterModel implements UserDetails {

    /**
     * 主键ID
     */
    private Long userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;
    /**
     * 账户类型 1超级管理员 2门店管理员
     */
    private Integer accountType;
    /**
     * 密码
     */
    private String password;

    /**
     * 所属门店
     */
    private String storeId;

    /**
     * 角色
     */
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
    private Date createDate;

    /**
     * 修改日期
     */
    private Date modifyDate;

    private List<HotelRole> roleList;

    public Long getUserId() {
        return userId;
    }

    public HotelUserInfoConverterModel setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public HotelUserInfoConverterModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public HotelUserInfoConverterModel setUserAccount(String userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public HotelUserInfoConverterModel setAccountType(Integer accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public HotelUserInfoConverterModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStoreId() {
        return storeId;
    }

    public HotelUserInfoConverterModel setStoreId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public HotelUserInfoConverterModel setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public HotelUserInfoConverterModel setDisabled(Integer disabled) {
        this.disabled = disabled;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public HotelUserInfoConverterModel setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public HotelUserInfoConverterModel setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public HotelUserInfoConverterModel setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public List<HotelRole> getRoleList() {
        return roleList;
    }

    public HotelUserInfoConverterModel setRoleList(List<HotelRole> roleList) {
        this.roleList = roleList;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roleList.size());
        for (HotelRole role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.userAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
