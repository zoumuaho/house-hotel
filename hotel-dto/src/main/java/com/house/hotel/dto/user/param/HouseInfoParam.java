package com.house.hotel.dto.user.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author muhao.zou
 * @date 2020/10/28 14:16
 */
@ApiModel(value = "房屋信息入参")
public class HouseInfoParam implements Serializable {

    private static final long serialVersionUID = -2535438855692240984L;
    @ApiModelProperty(value = "主键ID")
    private Long roomId;

    @ApiModelProperty(value = "房屋编号")
    private String roomNo;

    @ApiModelProperty(value = "房屋楼层")
    private String roomFloor;

    @ApiModelProperty(value = "所属门店")
    private Integer storeId;

    @ApiModelProperty(value = "房屋类型 1日租 2长租")
    private Integer roomType;

    @ApiModelProperty(value = "是否有效 1有效(默认) 0无效")
    private Integer disabled;

    @ApiModelProperty(value = "备注信息")
    private String remark;


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
