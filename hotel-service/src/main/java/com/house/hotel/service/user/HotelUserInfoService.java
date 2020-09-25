package com.house.hotel.service.user;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/25 11:41
 */
@Service
public class HotelUserInfoService {
    @Autowired
    private HotelUserInfoMapper hotelUserInfoMapper;

    public List<HotelUserInfo> listHotelUserInfo(){
        return hotelUserInfoMapper.selectAll();
    }
}
