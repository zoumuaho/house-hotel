package com.house.hotel.dao.mapper;

import com.house.hotel.dao.BaseMapper;
import com.house.hotel.dao.entity.HotelRole;
import com.house.hotel.dao.entity.HotelUserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelUserInfoMapper extends BaseMapper<HotelUserInfo> {

    List<HotelRole> getHrRolesById(Long id);
}