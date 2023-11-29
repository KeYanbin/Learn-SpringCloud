package com.aiguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 18:47
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class MainAppZK {
    public static void main(String[] args) {
        SpringApplication.run(MainAppZK.class, args);
    }
}
