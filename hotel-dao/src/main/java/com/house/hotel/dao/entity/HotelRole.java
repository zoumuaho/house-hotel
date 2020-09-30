package com.house.hotel.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "hotel_role")
public class HotelRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否有效 0无效 1有效
     */
    private Boolean disabled;

    @Column(name = "create_dare")
    private Date createDare;

    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * @return create_dare
     */
    public Date getCreateDare() {
        return createDare;
    }

    /**
     * @param createDare
     */
    public void setCreateDare(Date createDare) {
        this.createDare = createDare;
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