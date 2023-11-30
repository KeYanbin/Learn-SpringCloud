package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-29 23:23
 **/
@Configuration
public class MySelfRule {
    /**
     * 定义为随机
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}



