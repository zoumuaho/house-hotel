package com.house.hotel.service.user;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.dto.user.param.UserLoginParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 16:29
 */
@Service
public class UserLoginService {

    @Autowired
    private HotelUserInfoMapper hotelUserInfoMapper;

    /**
     * 用户登录
     *
     * @param loginParam 登录参数
     * @return 用户信息
     */
    public HotelUserInfoModel userLogin(UserLoginParam loginParam) {
        HotelUserInfoModel userInfoModel = new HotelUserInfoModel();
        HotelUserInfo hotelUserInfo = new HotelUserInfo();
        hotelUserInfo.setUserAccount(loginParam.getUsername());
        hotelUserInfo.setPassword(loginParam.getPassword());
        HotelUserInfo result = hotelUserInfoMapper.selectOne(hotelUserInfo);
        if (result == null) {
            return userInfoModel;
        }
        BeanUtils.copyProperties(hotelUserInfo, userInfoModel);
        return userInfoModel;
    }
}
