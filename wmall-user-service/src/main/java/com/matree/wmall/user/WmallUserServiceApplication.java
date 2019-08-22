package com.matree.wmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.matree.wmall.user.mapper")
public class WmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmallUserServiceApplication.class, args);
    }

}
