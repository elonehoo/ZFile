package com.zfile.code.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * [注册拦截器](Register interceptor)
 * @description: zh - 注册拦截器
 * @description: en - Register interceptor
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/26 4:39 下午
*/
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    /**
     * [注册Sa-Token的注解拦截器，打开注解式鉴权功能](Register the annotation interceptor of sa-token and open the annotation authentication function)
     * @description: zh - 注册Sa-Token的注解拦截器，打开注解式鉴权功能
     * @description: en - Register the annotation interceptor of sa-token and open the annotation authentication function
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/26 4:36 下午
     * @param registry: 注册表
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}

