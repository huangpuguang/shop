package com.hazer.config;

import com.hazer.model.IdWorker;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: IdWorkConfig
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-08 16:03
 **/
@EnableAutoConfiguration
public class IdWorkConfig {
    /***
     * IdWorker
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,0);
    }
}
