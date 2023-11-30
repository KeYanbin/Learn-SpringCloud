package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-30 09:11
 **/
@Component
public interface LoadBalancer {
    /**
     * 计算那个服务实例被调用
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
