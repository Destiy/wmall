package com.matree.wmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.matree.wmall.manage.mapper")
public class WmallManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmallManageServiceApplication.class, args);
    }

}
