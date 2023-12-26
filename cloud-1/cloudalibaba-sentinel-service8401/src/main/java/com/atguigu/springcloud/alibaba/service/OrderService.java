package com.atguigu.springcloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-21 09:30
 **/
@Slf4j
@Service
public class OrderService {
    @SentinelResource("queryOrder")
    public String queryGoods() {
        log.info("查询商品信息");
        return "queryGoods";
    }
}
