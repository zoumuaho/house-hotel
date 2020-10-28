package com.house.hotel.dao.entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "hotel_room")
public class HotelRoom {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "room_id")
    private Long roomId;

    /**
     * 房间编号
     */
    @Column(name = "room_no")
    private String roomNo;

    /**
     * 房间楼层
     */
    @Column(name = "room_floor")
    private String roomFloor;

    /**
     * 所属门店
     */
    @Column(name = "store_id")
    private Integer storeId;

    /**
     * 房间类型 1日租房 2长租房
     */
    @Column(name = "room_type")
    private Integer roomType;

    /**
     * 是否有效 1有效 0无效
     */
    private Integer disabled;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 获取主键ID
     *
     * @return room_id - 主键ID
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * 设置主键ID
     *
     * @param roomId 主键ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取房间编号
     *
     * @return room_no - 房间编号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 设置房间编号
     *
     * @param roomNo 房间编号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * 获取房间楼层
     *
     * @return romm_floor - 房间楼层
     */
    public String getRoomFloor() {
        return roomFloor;
    }

    /**
     * 设置房间楼层
     *
     * @param roomFloor 房间楼层
     */
    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    /**
     * 获取所属门店
     *
     * @return store_id - 所属门店
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 设置所属门店
     *
     * @param storeId 所属门店
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取房间类型 1日租房 2长租房
     *
     * @return room_type - 房间类型 1日租房 2长租房
     */
    public Integer getRoomType() {
        return roomType;
    }

    /**
     * 设置房间类型 1日租房 2长租房
     *
     * @param roomType 房间类型 1日租房 2长租房
     */
    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    /**
     * 获取是否有效 1有效 0无效
     *
     * @return disabled - 是否有效 1有效 0无效
     */
    public Integer getDisabled() {
        return disabled;
    }

    /**
     * 设置是否有效 1有效 0无效
     *
     * @param disabled 是否有效 1有效 0无效
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
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改时间
     *
     * @return modify_date - 修改时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置修改时间
     *
     * @param modifyDate 修改时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}