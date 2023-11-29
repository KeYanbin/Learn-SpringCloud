package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 21:00
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8006 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp8006.class, args);
    }

}
