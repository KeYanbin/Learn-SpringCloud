package com.atguigu.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-14 11:45
 **/
@Slf4j
@Component
@EnableBinding(Sink.class) // 绑定输入通道
public class ReceiveMessageListener
{
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) // 监听input通道，用于消费者队列的消息接收
    public void input(Message<String> message)
    {
        log.info("消费者1号，------->接收到的消息：{},\t port:{}" ,message.getPayload(),serverPort);
    }
}