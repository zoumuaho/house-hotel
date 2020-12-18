package com.house.hotel.service.house;

import com.house.hotel.commutil.enums.HotelUserOperationEnum;
import com.house.hotel.commutil.enums.ParamEnum;
import com.house.hotel.commutil.exception.HotelOperationException;
import com.house.hotel.dao.entity.HotelRoom;
import com.house.hotel.dao.mapper.HotelRoomMapper;
import com.house.hotel.dto.user.param.HouseInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author muhao.zou
 * @date 2020/10/28 14:14
 */
@Service
public class HouseManageService {
    @Autowired
    private HotelRoomMapper hotelRoomMapper;

    public int addHouse(HouseInfoParam houseInfoParam) {
        HotelRoom hotelRoom = this.transferHotelRoom(houseInfoParam);
        return hotelRoomMapper.insertSelective(hotelRoom);
    }


    public int modifyHouse(HouseInfoParam houseInfoParam) {
        if(houseInfoParam.getRoomId()== null || houseInfoParam.getRoomId() <1L){
            throw new HotelOperationException(ParamEnum.MISSING_NECESSARY_PARAM);
        }
        HotelRoom hotelRoom = this.transferHotelRoom(houseInfoParam);
        return hotelRoomMapper.updateByPrimaryKeySelective(hotelRoom);
    }

    private HotelRoom transferHotelRoom(HouseInfoParam houseInfoParam) {
        HotelRoom hotelRoom = new HotelRoom();
        if (houseInfoParam.getRoomId() == null || houseInfoParam.getRoomId() < 1L) {
            hotelRoom.setCreateDate(new Date());
        } else {
            hotelRoom.setRoomId(houseInfoParam.getRoomId());
        }
        hotelRoom.setRoomNo(houseInfoParam.getRoomNo());
        hotelRoom.setStoreId(houseInfoParam.getStoreId());
        hotelRoom.setRoomType(houseInfoParam.getRoomType());
        hotelRoom.setRoomFloor(houseInfoParam.getRoomFloor());
        hotelRoom.setRemark(houseInfoParam.getRemark());
        hotelRoom.setModifyDate(new Date());
        return hotelRoom;
    }
}
