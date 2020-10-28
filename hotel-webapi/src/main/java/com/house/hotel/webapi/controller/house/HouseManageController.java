package com.house.hotel.webapi.controller.house;

import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.dto.user.param.UserRegisterParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author muhao.zou
 * @date 2020/10/28 14:04
 */
@Api(value = "房子信息管理操作API文档", tags = "房子信息管理操作API文档")
@Controller
@RequestMapping("/hotel/house")
public class HouseManageController {
    /**
     * 跳转新增房屋信息页面
     * @return page
     */
    @GetMapping(value = "/addPage")
    public ModelAndView toAddHouse(){
        return new ModelAndView();
    }
    /**
     * 跳转修改房屋信息页面
     * @return page
     */
    @GetMapping(value = "/modifyPage")
    public ModelAndView toModifyHouse(){
        return new ModelAndView();
    }


    @ApiOperation(value = "新增房屋")
    @PostMapping(value = "/add")
    public BaseResult addUser(@Validated @ApiParam @RequestBody UserRegisterParam registerParam) {
        int count = 0;
        if (count > 0) {
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }

    @ApiOperation(value = "修改房屋")
    @PostMapping(value = "/modify")
    public BaseResult modifyUser() {
        int count = 0;
        if (count > 0) {
            return BaseResult.success(count);
        }
        return BaseResult.failed();
    }


}
