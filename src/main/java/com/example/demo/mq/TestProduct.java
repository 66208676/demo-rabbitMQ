package com.example.demo.mq;

import com.example.demo.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/5/31 18:00
 */
@Component
public class TestProduct {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFanoutQueue(String msg){
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_QUEUE_EXCHANGE,"",msg);
    }
}
