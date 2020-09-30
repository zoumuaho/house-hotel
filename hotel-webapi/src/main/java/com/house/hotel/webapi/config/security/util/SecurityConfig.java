package com.house.hotel.webapi.config.security.util;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.house.hotel.commutil.api.BaseResult;
import com.house.hotel.dao.model.HotelUserInfoConverterModel;
import com.house.hotel.service.user.HotelUserInfoQueryService;
import com.house.hotel.webapi.config.security.componet.CustomFilterInvocationSecurityMetadataSource;
import com.house.hotel.webapi.config.security.componet.CustomUrlDecisionManager;
import com.house.hotel.webapi.config.security.componet.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author muhao.zou
 * @date 2020/9/30 16:19
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private HotelUserInfoQueryService hotelUserInfoQueryService;
    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hotelUserInfoQueryService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/doc.html", "/swagger-ui.html","/swagger-resources/**","/swagger/**","/swagger/**","/**/v2/api-docs","/**/*.js",
                "/webjars/springfox-swagger-ui/**","/**/*.css","/**/*.png","/**/*.ico","/druid/**", "/favicon.ico", "/verifyCode", "/hotel/user/login");
    }

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    HotelUserInfoConverterModel userInfo = (HotelUserInfoConverterModel) authentication.getPrincipal();
                    userInfo.setPassword(null);
                    out.write(JSONUtil.toJsonStr(BaseResult.success(userInfo, "登录成功")));
                    out.flush();
                    out.close();
                }
        );
        loginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    BaseResult baseResult = BaseResult.failed(exception.getMessage());
                    if (exception instanceof LockedException) {
                        baseResult.setMessage("账户被锁定，请联系管理员!");
                    } else if (exception instanceof CredentialsExpiredException) {
                        baseResult.setMessage("密码过期，请联系管理员!");
                    } else if (exception instanceof AccountExpiredException) {
                        baseResult.setMessage("账户过期，请联系管理员!");
                    } else if (exception instanceof DisabledException) {
                        baseResult.setMessage("账户被禁用，请联系管理员!");
                    } else if (exception instanceof BadCredentialsException) {
                        baseResult.setMessage("用户名或者密码输入错误，请重新输入!");
                    }
                    out.write(JSONUtil.toJsonStr(BaseResult.success(baseResult)));
                    out.flush();
                    out.close();
                }
        );
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        ConcurrentSessionControlAuthenticationStrategy sessionStrategy = new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
        sessionStrategy.setMaximumSessions(1);
        loginFilter.setSessionAuthenticationStrategy(sessionStrategy);
        return loginFilter;
    }

    @Bean
    SessionRegistryImpl sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and()
                .logout()
                .logoutSuccessHandler((req, resp, authentication) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            out.write(JSONUtil.toJsonStr(BaseResult.success("登录成功")));
                            out.flush();
                            out.close();
                        }
                )
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                //没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint((req, resp, authException) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            resp.setStatus(401);
                            PrintWriter out = resp.getWriter();
                            BaseResult baseResult = BaseResult.failed("访问失败");
                            if (authException instanceof InsufficientAuthenticationException) {
                                baseResult.setMessage("请求失败，请联系管理员!");
                            }
                            out.write(JSONUtil.toJsonStr(BaseResult.success(baseResult)));
                            out.flush();
                            out.close();
                        }
                );
        http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry(), event -> {
            HttpServletResponse resp = event.getResponse();
            resp.setContentType("application/json;charset=utf-8");
            resp.setStatus(401);
            PrintWriter out = resp.getWriter();
            out.write(JSONUtil.toJsonStr(BaseResult.failed("您已在另一台设备登录，本次登录已下线!")));
            out.flush();
            out.close();
        }), ConcurrentSessionFilter.class);
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
