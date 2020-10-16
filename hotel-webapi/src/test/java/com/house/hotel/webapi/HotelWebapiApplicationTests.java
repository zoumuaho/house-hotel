package com.house.hotel.webapi;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dto.user.model.HotelMenuModel;
import com.house.hotel.service.RedisService;
import com.house.hotel.service.menu.HotelMenuService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelWebapiApplication.class)
class HotelWebapiApplicationTests {
	@Autowired
	HotelUserInfoMapper hotelUserInfoMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RedisService redisService;

	@Autowired
	private HotelMenuService hotelMenuService;
	@Test
	void contextLoads() {
		List<HotelUserInfo> hotelUserInfoList =  hotelUserInfoMapper.selectAll();
		hotelUserInfoList.forEach(v->{
			System.out.println(v.getUserName());
		});
	}
	@Test
	void encode(){
		System.out.println(passwordEncoder.encode("123456"));
	}
	@Test
	void testRedis(){
		System.out.println(redisService.get("aa"));
	}

	@Test
	void getMenuByUserId(){

		List<HotelMenuModel>hotelMenuModels =  hotelMenuService.getMenuByUserId(1L);

		for (HotelMenuModel hotelMenuModel : hotelMenuModels) {
			System.out.println(hotelMenuModel.getId() +"===========" + hotelMenuModel.getName());
		}

	}

}
