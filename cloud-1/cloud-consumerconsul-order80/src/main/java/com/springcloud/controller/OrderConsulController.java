package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 21:07
 **/
@Slf4j
@RestController
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        log.info("consumer: {}", INVOKE_URL);
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }

}
