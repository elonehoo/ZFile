package com.zfile;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * @author HCY
 * @since 2021/5/13 1:18 下午
*/
@EnableAdminServer
@SpringBootApplication
@MapperScan("com.zfile.code.mapper")
public class SpringBootZfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootZfileApplication.class, args);
    }

}
