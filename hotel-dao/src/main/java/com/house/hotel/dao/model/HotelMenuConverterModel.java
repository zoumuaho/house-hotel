package com.house.hotel.dao.model;

import com.house.hotel.dao.entity.HotelRole;

import java.util.Date;
import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/30 16:51
 */
public class HotelMenuConverterModel {
    private Integer id;
    /**
     * 路由
     */
    private String url;

    /**
     * 具体地址
     */
    private String path;

    /**
     * 备注
     */
    private String component;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 图片
     */
    private String iconCls;

    private Boolean keepalive;

    private Boolean requireAuth;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 是否有效 0无效 1有效
     */
    private Boolean disabled;

    private Date createDate;

    private Date modifyDate;

    private List<HotelMenuConverterModel> children;

    private List<HotelRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Boolean getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<HotelMenuConverterModel> getChildren() {
        return children;
    }

    public void setChildren(List<HotelMenuConverterModel> children) {
        this.children = children;
    }

    public List<HotelRole> getRoles() {
        return roles;
    }

    public void setRoles(List<HotelRole> roles) {
        this.roles = roles;
    }
}
