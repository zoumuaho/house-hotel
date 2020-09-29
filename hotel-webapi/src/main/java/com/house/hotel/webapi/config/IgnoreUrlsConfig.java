package com.house.hotel.webapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于配置不需要保护的资源路径
 * Created by macro on 2018/11/5.
 */
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

    public IgnoreUrlsConfig() {
    }

    public IgnoreUrlsConfig(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getUrls() {
        return urls;
    }

    public IgnoreUrlsConfig setUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }
}
