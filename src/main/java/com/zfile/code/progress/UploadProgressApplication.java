package com.zfile.code.progress;

import com.zfile.code.resolver.CustomMultipartResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;

/**
 * [将 spring 默认的文件上传处理类取消自动配置](Cancel the automatic configuration of spring's default file upload processing class)
 * @description: zh - 将 spring 默认的文件上传处理类取消自动配置
 * @description: en - Cancel the automatic configuration of spring's default file upload processing class
 * @version: V1.0
 * @author XiaoXunYao
 * @since 2021/6/29 11:31 上午
*/
@Configuration
@ComponentScan(basePackages = {"com.zfile"})
@ServletComponentScan(basePackages = {"com.zfile"})
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class UploadProgressApplication {

    /**
     * [自定义文件上传处理类](User defined file upload processing class)
     * @description: zh - 自定义文件上传处理类
     * @description: en - User defined file upload processing class
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 9:58 上午
     * @return org.springframework.web.multipart.MultipartResolver
     */
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CustomMultipartResolver customMultipartResolver = new CustomMultipartResolver();
        return customMultipartResolver;
    }

    public static void main(String[] args) {
        SpringApplication.run(UploadProgressApplication.class, args);
    }


}
