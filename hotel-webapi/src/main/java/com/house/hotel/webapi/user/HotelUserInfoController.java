package com.house.hotel.webapi.user;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.service.user.HotelUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/25 11:43
 */
@RestController
@RequestMapping(value = "/hotel/user")
public class HotelUserInfoController {

    @Autowired
    private HotelUserInfoService hotelUserInfoService;

    @GetMapping(value = "/list")
    public List<HotelUserInfo> getHotelUserInfoList() {
        return hotelUserInfoService.listHotelUserInfo();
    }
}
