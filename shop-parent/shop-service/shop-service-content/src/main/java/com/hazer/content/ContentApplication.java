package com.hazer.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName ContentApplication
 * @Description 广告启动类
 * @Author Hazer
 * @Date 2020/3/10 16:38
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.hazer.content.dao"})
public class ContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class,args);
    }
}
