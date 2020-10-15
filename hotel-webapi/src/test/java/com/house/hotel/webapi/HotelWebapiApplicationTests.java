package com.house.hotel.webapi;

import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.service.RedisService;
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
}
