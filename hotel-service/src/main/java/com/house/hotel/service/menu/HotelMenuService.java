package com.house.hotel.service.menu;

import com.house.hotel.dao.entity.HotelMenu;
import com.house.hotel.dao.mapper.HotelMenuMapper;
import com.house.hotel.dao.model.HotelMenuConverterModel;
import com.house.hotel.dto.user.model.HotelMenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author muhao.zou
 * @date 2020/9/30 17:19
 */
@Service
public class HotelMenuService {
    @Autowired
    private HotelMenuMapper hotelMenuMapper;

    public List<HotelMenuConverterModel> getAllMenusWithRole() {
        return hotelMenuMapper.getAllMenusWithRole();
    }


    public List<HotelMenuModel> getMenuByUserId(Long userId) {
        List<HotelMenu> hotelMenus =  hotelMenuMapper.getMenuByUserId(userId);
        List<HotelMenuModel> result = hotelMenus.stream()
                .filter(menu -> menu.getParentId().equals(0))
                .map(menu -> covertMenuNode(menu, hotelMenus)).collect(Collectors.toList());

        return result;
    }

    private HotelMenuModel covertMenuNode(HotelMenu menu, List<HotelMenu> menuList) {
        HotelMenuModel node = new HotelMenuModel();
        node.setParentLinkId(menu.getParentId());
        node.setName(menu.getName());
        node.setLinkPath(menu.getPath());
        node.setIcon(menu.getIconcls());
        node.setId(menu.getId());
        List<HotelMenuModel> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setSubMenus(children);
        return node;
    }

}
