package com.example.demo.mq;

import com.example.demo.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/5/31 18:00
 */
@Component
public class TestCustomer {
    @RabbitListener(bindings = {
           @QueueBinding(value = @Queue(value = RabbitConfig.FANOUT_QUEUE_NAME,durable = "true"),
           exchange = @Exchange(value = RabbitConfig.FANOUT_QUEUE_EXCHANGE,type = "fanout"))
    })
    @RabbitHandler
    public void processFanoutMsg(Message message){
        String str = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("=======监听消息1===========>"+str);
    }
}
