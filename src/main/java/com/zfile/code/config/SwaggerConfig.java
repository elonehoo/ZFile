package com.zfile.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * SwaggerConfig
 *
 * @author HCY
 * @since 2020/10/27
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                //开启个人信息
                .apiInfo(apiInfo())
                .select()
                .build()
                //每一个请求都可以添加header
                .globalRequestParameters(globalRequestParameters());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api文本
                .title("晓寻遥 api")
                //说明
                .description("更多请咨询晓寻遥")
                //用户名 + 网址 + 邮箱
                .contact(new Contact("晓寻遥" ,
                        "https://github.com/xiaoxunyao" ,
                        "2414776185@qq.com"))
                //版本
                .version("1.0")
                //运行
                .build();
    }

    private List<RequestParameter> globalRequestParameters() {
        RequestParameterBuilder parameterBuilder = new RequestParameterBuilder()
                //每次请求加载header
                .in(ParameterType.HEADER)
                //头标签
                .name("Token")
                .required(false)
                .query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
        return Collections.singletonList(parameterBuilder.build());
    }

}
