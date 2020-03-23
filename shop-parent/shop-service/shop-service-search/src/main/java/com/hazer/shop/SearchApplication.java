package com.hazer.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述
 *
 * @author Hazer
 * @version 1.0
 * @package com.shop.hazer *
 * @since 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.hazer.shop.goods.feign")
public class SearchApplication {


    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }

}
