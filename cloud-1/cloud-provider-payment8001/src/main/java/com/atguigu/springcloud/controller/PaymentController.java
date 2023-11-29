package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-27 19:12
 **/
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口:" + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id + "端口：" + port, null);
        }
    }

    @PostMapping(value = "/payment/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        log.info("*****插入结果: " + payment);
        int result = paymentService.insert(payment);
        if (result > 0) {
            return new CommonResult(200, "插入成功,端口:" + port, result);
        } else {
            return new CommonResult(444, "插入失败,端口:" + port, null);
        }
    }


    @GetMapping("/payment/discovery")
    public Object discovery() {
        // 获取服务列表信息 相当获取eureka上的服务列表
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element: " + element);
        }

        // 获取服务实例信息  根据服务名称获取服务实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            // 服务id 服务主机名称 服务端口号 服务uri地址
            log.info(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

}
