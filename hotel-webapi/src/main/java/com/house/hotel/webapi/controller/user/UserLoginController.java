package com.house.hotel.webapi.controller.user;

import com.house.hotel.dto.BaseResult;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.dto.user.param.UserLoginParam;
import com.house.hotel.service.user.UserLoginService;
import com.house.hotel.webapi.config.BaseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 15:35
 */
@Api(value = "用户登录API文档", tags = "用户登录API文档")
@RestController
@RequestMapping(value = "/hotel/user")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @ApiOperation("用户登录")
    @PostMapping(value = "/login")
    public BaseResult<HotelUserInfoModel> userLogin(@ApiParam @RequestBody UserLoginParam userLoginParam, BindingResult result) {
        HotelUserInfoModel hotelUserInfoModel = userLoginService.userLogin(userLoginParam);
        if (hotelUserInfoModel == null) {
            return BaseResult.validateFailed("用户名或者密码错误");
        }
        return BaseResult.success(hotelUserInfoModel);
    }
}
