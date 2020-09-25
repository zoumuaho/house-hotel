package com.house.hotel.webapi.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.yiguo.winchain.config.acm.AcmConfigManager;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;



@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {

    @Value("${swagger.enable}")
    private String enableSwagger;

    @Bean
    public Docket createRestApi() {
        boolean swaggerEnabled = AcmConfigManager.getInstance().getBooleanOrDefault("swagger.enable", true);
        if (!swaggerEnabled) {
            swaggerEnabled = BooleanUtils.toBoolean(enableSwagger, "true","false");
        }
        //可选header,query,path,body.form
        List<Parameter> pars = new ArrayList<>();
        pars.add(new ParameterBuilder().name("appId").description("渠道编号").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).defaultValue("30002").build());
        pars.add(new ParameterBuilder().name("PostTime").description("请求时间").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build());
        pars.add(new ParameterBuilder().name("LoginToken").description("用户token").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build());
        pars.add(new ParameterBuilder().name("SignCode").description("签名").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).defaultValue("aJZ5JsMh1Mi259kP").build());

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("鲸品用户中心接口文档")
                .description("鲸品用户中心的API接口文档")
                .version("1.3.1")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                //以扫描包的方式
                .apis(RequestHandlerSelectors.basePackage("com.yiguo.winchain.jingpin.usercenter.webapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .enable(swaggerEnabled);
    }
}
