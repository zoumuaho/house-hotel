package com.house.hotel.dao.mapper;


import com.house.hotel.dao.BaseMapper;
import com.house.hotel.dao.entity.HotelMenu;
import com.house.hotel.dao.model.HotelMenuConverterModel;

import java.util.List;

public interface HotelMenuMapper extends BaseMapper<HotelMenu> {
    /**
     * 查询所有菜单和所有角色
     * @return
     */
    List<HotelMenuConverterModel> getAllMenusWithRole();
}