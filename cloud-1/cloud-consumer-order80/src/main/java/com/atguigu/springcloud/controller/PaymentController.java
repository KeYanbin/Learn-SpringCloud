package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-27 19:12
 **/
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class PaymentController {

    // private static final String PAYMENT_URL = "http://localhost:8001";

    // 通过在eureka上注册过的微服务名称调用
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable Long id) {
        log.info("请求ID为：{}", id);
        // 参数1：url 参数2：返回值类型
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable Long id) {
        log.info("请求ID为：{}", id);
        // 参数1：url 参数2：返回值类型
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("获取响应状态码：{}", entity.getStatusCode());
            log.info("获取响应头：{}", entity.getHeaders());
            log.info("获取响应体：{}", entity.getBody());
            // 返回响应体
            return entity.getBody();
        } else {
            log.info("请求失败，返回值为：{}", entity.getStatusCode());
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping(value = "/insert")
    public CommonResult insert(Payment payment) {
        log.info("请求参数为：{}", payment);
        // 参数1：url 参数2：请求参数 参数3：返回类型
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }


    @GetMapping("/postForEntity")
    public CommonResult insert2(Payment payment) {
        log.info("请求参数为：{}", payment);
        // 参数1：url 参数2：请求参数 参数3：返回类型
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("获取响应状态码：{}", entity.getStatusCode());
            log.info("获取响应头：{}", entity.getHeaders());
            log.info("获取响应体：{}", entity.getBody());
            // 返回响应体
            return entity.getBody();
        } else {
            log.info("请求失败，返回值为：{}", entity.getStatusCode());
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        // 获取服务实例信息  根据服务名称获取服务实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        // 获取服务实例的uri
        URI uri = loadBalancer.instances(instances).getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

}
