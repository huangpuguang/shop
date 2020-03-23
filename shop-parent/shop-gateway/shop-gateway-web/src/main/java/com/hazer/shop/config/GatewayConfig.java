package com.hazer.shop.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @description: ip限流
 * @author: Hazer
 * @time: 2020/3/23 14:00
 */
@Component
public class GatewayConfig {
    /***
     * IP限流
     * @return
     */
    @Bean(name = "ipKeyResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> {
            //获取远程客户端IP
            String hostName = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            System.out.println("hostName:" + hostName);
            return Mono.just(hostName);
        };
    }
}
