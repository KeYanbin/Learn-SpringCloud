package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-11 15:17
 **/
@RefreshScope
@RestController
public class ConfigClientController {
    // ${config.info} -> 获取的配置文件中的 config.info 的值
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
