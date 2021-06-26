package com.zfile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * @author HCY
 * @since 2021/5/13 1:18 下午
*/
@SpringBootApplication
@MapperScan("com.zfile.code.mapper")
public class SpringBootZfileApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootZfileApplication.class);
        //运行
        springApplication.run(args);
    }

}
