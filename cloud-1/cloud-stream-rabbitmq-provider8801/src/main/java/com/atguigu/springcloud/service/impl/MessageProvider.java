package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: keyanbin
 * @description:
 * @create: 2023-12-14 11:05
 **/
@Slf4j
@EnableBinding(Source.class) // 绑定消息的推送管道
public class MessageProvider implements IMessageProvider {
    @Resource
    MessageChannel output; // 消息发送管道
    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        log.info("uuid: {}", uuid);
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
