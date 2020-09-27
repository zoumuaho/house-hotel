package com.house.hotel.webapi.controller.user;

import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.dto.user.param.UserRegisterParam;
import com.house.hotel.service.user.HotelUserInfoManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muhao.zou
 * @date 2020/9/27 16:03
 */
@Api(value = "用户信息管理操作API文档", tags = "用户信息管理操作API文档")
@RestController
@RequestMapping(value = "/hotel/user/manage")
public class HotelUserInfoManageController {
    @Autowired
    private HotelUserInfoManageService userInfoManageService;

    @ApiOperation(value = "新增用户")
    @PostMapping(value = "/add")
    public BaseResult addUser(@ApiParam @RequestBody UserRegisterParam registerParam) {
        int count = userInfoManageService.addUser(registerParam);
        if (count > 0) {
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }

    @ApiOperation(value = "修改用户")
    @PostMapping(value = "/modify")
    public BaseResult modifyUser() {
        int count = userInfoManageService.modifyUser();
        if (count > 0) {
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }

    @ApiOperation(value = "删除用户")
    @PostMapping(value = "/delete")
    public BaseResult delUser() {
        int count = userInfoManageService.delUser();
        if (count > 0) {
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }
}