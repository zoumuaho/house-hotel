package com.house.hotel.commutil.enums;

/**
 * @auhtor muhao.zou
 * @date 2020/10/15 22:00
 */
public enum RedisEnum {
    USER_LOGIN("token_%s",7200)
    ;

    private String TOKEN_PREFIX;

    private Integer EXPIRE;

    RedisEnum(String TOKEN_PREFIX, Integer EXPIRE) {
        this.TOKEN_PREFIX = TOKEN_PREFIX;
        this.EXPIRE = EXPIRE;
    }

    public String getTOKEN_PREFIX() {
        return TOKEN_PREFIX;
    }

    public RedisEnum setTOKEN_PREFIX(String TOKEN_PREFIX) {
        this.TOKEN_PREFIX = TOKEN_PREFIX;
        return this;
    }

    public Integer getEXPIRE() {
        return EXPIRE;
    }

    public RedisEnum setEXPIRE(Integer EXPIRE) {
        this.EXPIRE = EXPIRE;
        return this;
    }
}
