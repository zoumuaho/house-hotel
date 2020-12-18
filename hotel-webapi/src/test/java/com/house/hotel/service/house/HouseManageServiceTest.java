package com.house.hotel.service.house;

import com.house.hotel.dto.user.param.HouseInfoParam;
import com.house.hotel.webapi.HotelWebapiApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author muhao.zou
 * @date 2020/10/28 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelWebapiApplication.class)
class HouseManageServiceTest {
    @Autowired
    private HouseManageService houseManageService;
    @Test
    void addHouse() {

        HouseInfoParam houseInfoParam = new HouseInfoParam();
        houseInfoParam.setRoomNo("C1001");
        houseInfoParam.setRoomType(1);
        houseInfoParam.setStoreId(1);
        houseInfoParam.setRoomFloor("1L");
        houseInfoParam.setRemark("测试数据");
        houseInfoParam.setDisabled(1);
        houseManageService.addHouse(houseInfoParam);
    }

    @Test
    void modifyHouse() {
        HouseInfoParam houseInfoParam = new HouseInfoParam();
        //houseInfoParam.setRoomId(1L);
        houseInfoParam.setRoomNo("C2002");
        houseInfoParam.setRoomType(1);
        houseInfoParam.setStoreId(1);
        houseInfoParam.setRoomFloor("2L");
        houseInfoParam.setRemark("测试数据");
        houseInfoParam.setDisabled(1);
        houseManageService.modifyHouse(houseInfoParam);
    }
}