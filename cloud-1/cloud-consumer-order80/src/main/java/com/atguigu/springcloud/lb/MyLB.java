package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-11-30 09:13
 **/
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.nextServerCyclicCounter.get();
            next = current == Integer.MAX_VALUE ? 0 : current + 1;
            /*
              CAS
              自旋锁
              this.nextServerCyclicCounter.compareAndSet(current, next) 当前值和期望值相同时，修改为新值
             */
        } while (!this.nextServerCyclicCounter.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 得到服务器的下标位置
        // 接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
