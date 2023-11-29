package com.springcloud.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 21:00
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentInfo() {
        return "SpringCloud with consul: " + serverPort + "\t\t" + UUID.randomUUID().toString();
    }
}
