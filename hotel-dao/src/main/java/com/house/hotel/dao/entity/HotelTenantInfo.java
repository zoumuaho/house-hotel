package com.house.hotel.dao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hotel_tenant_info")
public class HotelTenantInfo {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "tenant_id")
    private Integer tenantId;

    /**
     * 获取主键ID
     *
     * @return tenant_id - 主键ID
     */
    public Integer getTenantId() {
        return tenantId;
    }

    /**
     * 设置主键ID
     *
     * @param tenantId 主键ID
     */
    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }
}