package com.hazer.shop.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: Hazer
 * @time: 2020/3/23 18:17
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hazer.shop.users.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
