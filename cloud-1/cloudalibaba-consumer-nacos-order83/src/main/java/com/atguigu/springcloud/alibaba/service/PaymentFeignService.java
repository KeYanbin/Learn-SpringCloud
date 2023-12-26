package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: keyanbin
 * @description: 调用服务接口
 * @create: 2023-12-18 10:12
 **/
@FeignClient(value = "${feign.nacos-user-service}", contextId = "PaymentFeignService")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);
}
