package com.house.hotel.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

@MapperScan(basePackages = "com.house.hotel.dao.mapper.*")
public class HotelWebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelWebapiApplication.class, args);
	}

}
