package com.house.hotel.webapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auhtor muhao.zou
 * @date 2020/9/27 23:54
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.house.hotel.dao.mapper"})
public class MyBatisConfig {
}
