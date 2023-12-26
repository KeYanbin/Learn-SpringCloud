package com.atguigu.springcloud.alibaba.MyHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-21 15:21
 **/
public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(4444,"自定义的限流处理信息......handleException-----1");
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(4444,"自定义的限流处理信息......handleException-----2");
    }
}
