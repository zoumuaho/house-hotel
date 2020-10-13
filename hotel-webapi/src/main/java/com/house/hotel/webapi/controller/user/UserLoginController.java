package com.house.hotel.webapi.controller.user;

import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.dto.user.param.UserLoginParam;
import com.house.hotel.service.user.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 15:35
 */
@Api(value = "用户登录API文档", tags = "用户登录API文档")
@RestController
@RequestMapping(value = "/hotel/user")
public class UserLoginController {

    @Autowired
    private UserAdminService userAdminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("用户登录")
    @PostMapping(value = "/login")
    public BaseResult userLogin(@RequestBody UserLoginParam userLoginParam) {
        String token = userAdminService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (token == null) {
            return BaseResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return BaseResult.success(tokenMap);
    }
}
