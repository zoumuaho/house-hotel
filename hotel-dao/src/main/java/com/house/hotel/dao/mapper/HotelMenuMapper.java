package com.house.hotel.dao.mapper;


import com.house.hotel.dao.BaseMapper;
import com.house.hotel.dao.entity.HotelMenu;
import com.house.hotel.dao.model.HotelMenuConverterModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelMenuMapper extends BaseMapper<HotelMenu> {
    /**
     * 查询所有菜单和所有角色
     * @return
     */
    List<HotelMenuConverterModel> getAllMenusWithRole();

    /**
     * 根据用户Id查询菜单列表
     * @param userId yon
     * @return
     */
    List<HotelMenu> getMenuByUserId(Long userId);
}
