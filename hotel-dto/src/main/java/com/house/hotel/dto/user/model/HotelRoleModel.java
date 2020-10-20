package com.house.hotel.dto.user.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @auhtor muhao.zou
 * @date 2020/10/17 17:02
 */
@ApiModel(value = "角色DTO")
public class HotelRoleModel implements Serializable {


    private static final long serialVersionUID = 7933198572761874631L;

    private Integer id;

    private String name;

    private String roleName;

    private String remark;

    private String disabled;

    private Date createDate;


    public Integer getId() {
        return id;
    }

    public HotelRoleModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HotelRoleModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public HotelRoleModel setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public HotelRoleModel setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getDisabled() {
        return disabled;
    }

    public HotelRoleModel setDisabled(String disabled) {
        this.disabled = disabled;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public HotelRoleModel setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }
}
