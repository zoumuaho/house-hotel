package com.house.hotel.webapi.controller.user;

import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.commutil.api.CookieUtil;
import com.house.hotel.commutil.enums.RedisEnum;
import com.house.hotel.dto.user.param.UserLoginParam;
import com.house.hotel.service.RedisService;
import com.house.hotel.service.user.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisService redisService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login")
    public BaseResult userLogin(@RequestBody UserLoginParam userLoginParam ,HttpServletResponse response) {
        String token = userAdminService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (token == null) {
            return BaseResult.validateFailed("用户名或密码错误");
        }
        //将token保存至redis
        redisService.set(this.tokenHeader, token, RedisEnum.USER_LOGIN.getEXPIRE());

        //3. 设置token至cookie
        CookieUtil.set(response, this.tokenHeader, token, RedisEnum.USER_LOGIN.getEXPIRE());

        return BaseResult.success(null);
    }
    @ApiOperation("退出登录")
    @RequestMapping("/logout")
    public BaseResult loginOut(HttpServletResponse response){
        //移除redis中token
        redisService.del(this.tokenHeader);

        //3. 清除cookie
        CookieUtil.set(response, this.tokenHeader, null, 0);
        return BaseResult.success(null);
    }
}
