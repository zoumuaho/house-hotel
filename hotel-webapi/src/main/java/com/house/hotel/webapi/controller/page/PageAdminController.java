package com.house.hotel.webapi.controller.page;

import com.house.hotel.dao.entity.HotelMenu;
import com.house.hotel.service.menu.HotelMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author muhao.zou
 * @date 2020/10/14 18:18
 */
@Controller
@RequestMapping("/hotel/user")
public class PageAdminController {
    @Autowired
    private HotelMenuService hotelMenuService;
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(){
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ModelAndView("index");
    }
}
