package com.aiguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 18:49
 **/
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced // 赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
