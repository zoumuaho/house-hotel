package com.house.hotel.webapi.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
       /* boolean swaggerEnabled = false;//AcmConfigManager.getInstance().getBooleanOrDefault("swagger.enable", true);
        if (!swaggerEnabled) {
            swaggerEnabled = BooleanUtils.toBoolean(enableSwagger, "true","false");
        }*/
        //可选header,query,path,body.form
        /*List<Parameter> pars = new ArrayList<>();
        pars.add(new ParameterBuilder().name("appId").description("渠道编号").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).defaultValue("30002").build());
        pars.add(new ParameterBuilder().name("PostTime").description("请求时间").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build());
        pars.add(new ParameterBuilder().name("LoginToken").description("用户token").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build());
        pars.add(new ParameterBuilder().name("SignCode").description("签名").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).defaultValue("aJZ5JsMh1Mi259kP").build());*/

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("house hotel swagger-bootstrap-ui Restful APIs 默认访问地址:http://${host}:${port}/doc.html")
                .description("house hotel swagger-bootstrap-ui Restful APIs")
                .version("1.0.0")
                .termsOfServiceUrl("http://localhost:8080/")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                //以扫描包的方式
                .apis(RequestHandlerSelectors.basePackage("com.house.hotel.webapi.controller"))
                .paths(PathSelectors.any())
                .build()
                //.globalOperationParameters(pars)
                .enable(true);
    }
}
