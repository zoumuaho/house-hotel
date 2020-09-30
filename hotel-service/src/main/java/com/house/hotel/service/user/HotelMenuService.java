package com.house.hotel.service.user;

import com.house.hotel.dao.mapper.HotelMenuMapper;
import com.house.hotel.dao.model.HotelMenuConverterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
