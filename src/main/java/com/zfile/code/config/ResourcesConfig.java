package com.zfile.code.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * [资源配置类](Resource allocation)
 * @description: zh - 资源配置类
 * @description: en - Resource allocation
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/7/10 9:36 上午
*/
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/zfile/**").addResourceLocations("classpath:/static/");
    }


}
