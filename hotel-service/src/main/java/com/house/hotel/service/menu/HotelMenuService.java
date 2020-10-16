package com.house.hotel.service.menu;

import com.house.hotel.dao.entity.HotelMenu;
import com.house.hotel.dao.mapper.HotelMenuMapper;
import com.house.hotel.dao.model.HotelMenuConverterModel;
import com.house.hotel.dto.user.model.HotelMenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/30 17:19
 */
@Service
public class HotelMenuService {
    @Autowired
    private HotelMenuMapper hotelMenuMapper;

    public List<HotelMenuConverterModel> getAllMenusWithRole() {
        return hotelMenuMapper.getAllMenusWithRole();
    }


    public List<HotelMenuModel> getMenuByUserId() {
        List<HotelMenuModel> list = new ArrayList<>();
        return list;
    }

}
