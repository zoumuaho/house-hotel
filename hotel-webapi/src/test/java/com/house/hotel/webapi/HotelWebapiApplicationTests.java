package com.house.hotel.webapi;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HotelWebapiApplication.class)
class HotelWebapiApplicationTests {
	@Autowired
	private HotelUserInfoMapper hotelUserInfoMapper;

	@Test
	void contextLoads() {
		List<HotelUserInfo> hotelUserInfoList =  hotelUserInfoMapper.selectAll();
		hotelUserInfoList.forEach(v->{
			System.out.println(v.getUserName());
		});
	}

}
