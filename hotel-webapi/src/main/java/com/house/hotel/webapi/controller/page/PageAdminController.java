package com.house.hotel.webapi.controller.page;

import com.alibaba.fastjson.JSON;
import com.house.hotel.dao.entity.HotelMenu;
import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.model.HotelUserInfoConverterModel;
import com.house.hotel.dto.user.model.HotelMenuModel;
import com.house.hotel.service.RedisService;
import com.house.hotel.service.menu.HotelMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/10/14 18:18
 */
@Controller
@RequestMapping("/hotel/user")
public class PageAdminController {
    @Autowired
    private HotelMenuService hotelMenuService;
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;
    @Autowired
    private RedisService redisService;
    private static final String MENU_KEY = "menu_%s";
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        Long userId = ((HotelUserInfoConverterModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        String key = String.format(MENU_KEY,userId);
        String menuData="";
        if(redisService.hasKey(key)){
            menuData = (String)redisService.get(key);
            thymeleafViewResolver.addStaticVariable("menuData",menuData);
        }else{
            List<HotelMenuModel> hotelMenuModelList = hotelMenuService.getMenuByUserId(userId);
            menuData = JSON.toJSONString(hotelMenuModelList);
            redisService.set(key,menuData);
            //设置静态资源全局获取
            thymeleafViewResolver.addStaticVariable("menuData",menuData);
        }
        return new ModelAndView("index", "menuData", menuData);
    }
}
