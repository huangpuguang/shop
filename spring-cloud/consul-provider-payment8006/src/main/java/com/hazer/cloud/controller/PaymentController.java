package com.hazer.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: payment
 * @description:
 * @author: Hazer
 * @create: 2020-03-16 22:11
 **/
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul()
    {
        return "springCloud with consul: "+serverPort+"\t   "+ UUID.randomUUID().toString();
    }
}
