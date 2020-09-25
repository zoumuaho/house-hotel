package com.house.hotel.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.house.hotel.dao.mapper")
@ComponentScan(basePackages = {"com.house.hotel"})

public class HotelWebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelWebapiApplication.class, args);
	}

}
