package com.house.hotel.webapi.controller.user;

import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.service.user.HotelUserInfoQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/25 11:43
 */
@Api(value = "用户信息查询API文档", tags = "用户信息查询API文档")
@Controller
@RequestMapping(value = "/hotel/user")
public class HotelUserInfoQueryController {

    @Autowired
    private HotelUserInfoQueryService hotelUserInfoService;

    @ApiOperation(value = "查询用户信息列表")
    @GetMapping(value = "/list")
    public ModelAndView getHotelUserInfoList() {
         List<HotelUserInfoModel> userInfoModelList = hotelUserInfoService.listHotelUserInfo();
        return new ModelAndView("admin-list","userInfoModelList",userInfoModelList);
    }

}
