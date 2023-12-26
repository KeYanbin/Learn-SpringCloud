package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-18 10:16
 **/
@Slf4j
@RestController
public class OrderNacosController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return paymentFeignService.getPayment(id);
    }

}
