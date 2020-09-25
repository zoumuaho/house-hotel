package com.house.hotel.webapi.controller.user;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.service.user.HotelUserInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/25 11:43
 */
@Api(value = "用户信息查询API文档",tags = "用户信息查询API文档")
@RestController
@RequestMapping(value = "/hotel/user")
public class HotelUserInfoQueryController {

    @Autowired
    private HotelUserInfoService hotelUserInfoService;

    @GetMapping(value = "/list")
    public List<HotelUserInfo> getHotelUserInfoList() {
        return hotelUserInfoService.listHotelUserInfo();
    }
}
