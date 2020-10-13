package com.house.hotel.service.user;

import com.house.hotel.commutil.api.JwtTokenUtil;
import com.house.hotel.dao.entity.HotelUserInfo;
import com.house.hotel.dao.mapper.HotelUserInfoMapper;
import com.house.hotel.dto.user.model.HotelUserInfoModel;
import com.house.hotel.dto.user.param.UserLoginParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @auhtor muhao.zou
 * @date 2020/9/26 16:29
 */
@Service
public class UserLoginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginService.class);

    @Autowired
    private HotelUserInfoMapper hotelUserInfoMapper;
    @Autowired
    private HotelUserInfoQueryService hotelUserInfoQueryService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = hotelUserInfoQueryService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }
}
