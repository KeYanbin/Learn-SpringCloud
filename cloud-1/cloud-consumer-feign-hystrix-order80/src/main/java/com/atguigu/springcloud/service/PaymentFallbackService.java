package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: keyanbin
 * @description: 服务降级处理类
 * @create: 2023-12-05 21:31
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "调用方法---paymentInfo_OK-----，服务器繁忙，请稍后再试！";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "调用方法---paymentInfo_TimeOut-----，服务器繁忙，请稍后再试！";
    }
}
