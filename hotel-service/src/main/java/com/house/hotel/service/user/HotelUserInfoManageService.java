package com.house.hotel.service.user;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dto.user.param.UserRegisterParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author muhao.zou
 * @date 2020/9/27 16:17
 */
@Service
public class HotelUserInfoManageService {
    @Autowired
    private HotelUserInfoMapper userInfoMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public int addUser(UserRegisterParam registerParam) {
        HotelUserInfo hotelUserInfo = new HotelUserInfo();
        hotelUserInfo.setUserName(registerParam.getUserName())
                .setUserAccount(registerParam.getUserAccount())
                .setAccountType(registerParam.getAccountType())
                .setPassword(passwordEncoder.encode(registerParam.getPassword()))
                .setCreateDate(new Date())
                .setModifyDate(new Date())
                .setDisabled(1);
        return userInfoMapper.insertUseGeneratedKeys(hotelUserInfo);
    }

    public int modifyUser() {
        return 0;
    }

    public int delUser() {
        return 0;
    }

}
