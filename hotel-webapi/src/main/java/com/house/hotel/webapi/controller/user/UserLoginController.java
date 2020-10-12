package com.house.hotel.webapi.controller.user;

import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.dto.user.param.UserLoginParam;
import com.house.hotel.service.user.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BaseResult<HotelUserInfoModel> userLogin(@RequestBody UserLoginParam userLoginParam) {
        return BaseResult.failed("尚未登录，请登录!");
    }
}
