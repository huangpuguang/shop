package com.hazer.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: Hazer
 * @time: 2020/3/19 18:08
 */
@SpringBootApplication
@EnableEurekaClient
public class WebGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebGatewayApplication.class,args);
    }
}
