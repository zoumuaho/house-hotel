package com.house.hotel.dto.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单模型
 * @author muhao.zou
 * @date 2020/10/16 16:50
 */
@ApiModel(value = "菜单模型DTO")
public class HotelMenuModel implements Serializable {
    private static final long serialVersionUID = 6467768845046494612L;
    @ApiModelProperty(value = "菜单ID")
    private Integer id;
    @ApiModelProperty(value = "菜单名称")
    private String name;
    @ApiModelProperty(value = "菜单路由")
    private String linkPath;
    @ApiModelProperty(value = "菜单icon")
    private String icon;
    @ApiModelProperty(value = "父菜单ID")
    private Integer parentLinkId;
    @ApiModelProperty(value = "子菜单集合")
    private List<HotelMenuModel> subMenus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkPath() {
        return linkPath;
    }

    public void setLinkPath(String linkPath) {
        this.linkPath = linkPath;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentLinkId() {
        return parentLinkId;
    }

    public void setParentLinkId(Integer parentLinkId) {
        this.parentLinkId = parentLinkId;
    }

    public List<HotelMenuModel> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<HotelMenuModel> subMenus) {
        this.subMenus = subMenus;
    }
}
