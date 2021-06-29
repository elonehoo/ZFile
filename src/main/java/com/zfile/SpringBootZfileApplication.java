package com.zfile;

import com.zfile.code.resolver.CustomMultipartResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

/**
 * 程序入口
 * @author HCY
 * @since 2021/5/13 1:18 下午
*/
@SpringBootApplication
@MapperScan("com.zfile.code.mapper")
public class SpringBootZfileApplication {

    /**
     * [Core entry class](Core entry class)
     * @description: zh - 核心入口类
     * @description: en - Core entry class
     * @version: V1.0
     * @author XiaoXunYao
     * @since 2021/6/29 9:58 上午
     * @param args: 参数
    */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootZfileApplication.class);
        //运行
        springApplication.run(args);
    }

}
