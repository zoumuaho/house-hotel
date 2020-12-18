package com.house.hotel.webapi.controller.user;

import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.dto.user.model.HotelRoleModel;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.dto.user.param.UserRegisterParam;
import com.house.hotel.service.user.HotelUserInfoQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> hashMap= new HashMap<>();
        hashMap.put("size",userInfoModelList.size());
        hashMap.put("userInfoModelList",userInfoModelList);
        return new ModelAndView("admin-list", hashMap);
    }

    @GetMapping(value = "/admin-add-page")
    public ModelAndView toAddUserPage() {
        List<HotelRoleModel> hotelRoleModelList = hotelUserInfoService.listHotelRole();
        return new ModelAndView("admin-add", "roleList", hotelRoleModelList);
    }
    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/admin-add")
    @ResponseBody
    public BaseResult addUser(@ApiParam @RequestBody UserRegisterParam userInfoParam) {
        int count = hotelUserInfoService.saveUser(userInfoParam);
        if(count > 0){
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }

    @ApiOperation(value = "修改用户")
    @PostMapping(value = "/admin-modify")
    @ResponseBody
    public BaseResult modifyUser(@ApiParam @RequestBody UserRegisterParam userInfoParam) {
        int count = hotelUserInfoService.modifyUser(userInfoParam);
        if(count > 0){
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }
}
