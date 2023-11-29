package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-27 19:09
 **/
public interface PaymentService {
    int insert(Payment payment);
    Payment getPaymentById(Long id);
}
