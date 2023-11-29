package com.aiguigu.cpringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 17:52
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8004 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8004.class, args);
    }
}
