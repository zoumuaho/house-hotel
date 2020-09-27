package com.house.hotel.service.user;

import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dto.user.param.UserRegisterParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muhao.zou
 * @date 2020/9/27 16:17
 */
@Service
public class HotelUserInfoManageService {
    @Autowired
    private HotelUserInfoMapper userInfoMapper;

    public int addUser(UserRegisterParam registerParam){


        return 0;
    }

    public int modifyUser(){
        return 0;
    }

    public int delUser(){
        return 0;
    }

}
