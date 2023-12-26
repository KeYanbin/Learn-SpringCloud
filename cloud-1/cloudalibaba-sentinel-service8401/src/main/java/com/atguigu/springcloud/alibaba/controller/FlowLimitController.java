package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-21 08:29
 **/
@Slf4j
@RestController
public class FlowLimitController {
    @Resource
    private OrderService orderService;
    @GetMapping("/testA")
    public String testA() {
        // try {
        //     Thread.sleep(800);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        log.info("testC 测试");
        return "testC"+orderService.queryGoods();
    }
    @GetMapping("/testD")
    public String testD() {
        return "testD"+orderService.queryGoods();
    }

    /**
     * 慢调用比例
     * @return
     */
    @GetMapping("/testE/{id}")
    public String testE(@PathVariable Integer id) {
        if (id == 1){
            try {
                // 暂停1秒钟
                // TimeUnit.SECONDS.sleep(1);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (id==2) {
            throw new RuntimeException("id为2，自定义异常");
        }
        return "testE"+orderService.queryGoods();
    }

    /**
     * 热点规则
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handler_HotKey") // value值要唯一 blockHandler指定兜底方法
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "----testHotKey";
    }

    //处理异常方法，方法签名要和对应的接口方法保持一致,参数最后多一个BlockException
    public String handler_HotKey(String p1, String p2, BlockException exception){
        return "系统繁忙稍后重试。。";
    }
}
