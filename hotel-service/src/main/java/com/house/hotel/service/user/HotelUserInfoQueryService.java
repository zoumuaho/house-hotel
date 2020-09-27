package com.house.hotel.service.user;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muhao.zou
 * @date 2020/9/25 11:41
 */
@Service
public class HotelUserInfoQueryService {
    @Autowired
    private HotelUserInfoMapper hotelUserInfoMapper;

    public List<HotelUserInfoModel> listHotelUserInfo() {
        List<HotelUserInfo> hotelUserInfoList = hotelUserInfoMapper.selectAll();
        List<HotelUserInfoModel> hotelUserInfoModelList = new ArrayList<>();
        if (null == hotelUserInfoList || hotelUserInfoList.isEmpty()) {
            return hotelUserInfoModelList;
        }
        hotelUserInfoList.forEach(v -> {
            HotelUserInfoModel userInfoModel = new HotelUserInfoModel();
            BeanUtils.copyProperties(v, userInfoModel);
            hotelUserInfoModelList.add(userInfoModel);
        });
        return hotelUserInfoModelList;
    }
}
