package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-30 21:27
 **/
@RequestMapping("/payment")
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",contextId = "OrderClient") // 指定调用哪个微服务  value:指定微服务的名称
public interface PaymentFeignService {
    /**
     * 调用微服务的接口
     * 拼接的地址为：http://CLOUD-PAYMENT-SERVICE/payment/get/{id}
     *
     * @param id 传入的id
     * @return 返回的结果
     */
    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 测试feign超时控制
     * @return 返回的结果
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout();
}
