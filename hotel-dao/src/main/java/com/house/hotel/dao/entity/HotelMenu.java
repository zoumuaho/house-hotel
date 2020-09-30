package com.house.hotel.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "hotel_menu")
public class HotelMenu {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 路由
     */
    @Column(name = "url")
    private String url;

    /**
     * 具体地址
     */
    @Column(name = "path")
    private String path;

    /**
     * 备注
     */
    @Column(name = "component")
    private String component;

    /**
     * 菜单名
     */
    @Column(name = "name")
    private String name;

    /**
     * 图片
     */
    @Column(name = "iconCls")
    private String iconcls;

    @Column(name = "keep_alive")
    private Boolean keepalive;

    @Column(name = "require_auth")
    private Boolean requireAuth;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 是否有效 0无效 1有效
     */
    private Boolean disabled;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取路由
     *
     * @return url - 路由
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置路由
     *
     * @param url 路由
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取具体地址
     *
     * @return path - 具体地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置具体地址
     *
     * @param path 具体地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取备注
     *
     * @return component - 备注
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置备注
     *
     * @param component 备注
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取菜单名
     *
     * @return name - 菜单名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名
     *
     * @param name 菜单名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片
     *
     * @return iconCls - 图片
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * 设置图片
     *
     * @param iconcls 图片
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    /**
     * @return keepAlive
     */
    public Boolean getKeepalive() {
        return keepalive;
    }

    /**
     * @param keepalive
     */
    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    /**
     * @return requireAuth
     */
    public Boolean getRequireAuth() {
        return requireAuth;
    }

    /**
     * @param requireAuth
     */
    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }

    /**
     * 获取父id
     *
     * @return parentId - 父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentid(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取是否有效 0无效 1有效
     *
     * @return disabled - 是否有效 0无效 1有效
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * 设置是否有效 0无效 1有效
     *
     * @param disabled 是否有效 0无效 1有效
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return modify_date
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}