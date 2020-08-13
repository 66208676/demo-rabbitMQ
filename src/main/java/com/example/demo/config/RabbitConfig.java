package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/5/30 18:42
 */
@Configuration
public class RabbitConfig {
    public static final String FANOUT_QUEUE_NAME = "test_fanout_queue";
    public static final String FANOUT_QUEUE_EXCHANGE = "fanoutExchange";
    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue createFanoutQueue(){
        return new Queue(FANOUT_QUEUE_NAME);
    }

    /**
     * 创建交换机
     * @return
     */
    @Bean
    public FanoutExchange defFanoutExchange(){
        return new FanoutExchange(FANOUT_QUEUE_EXCHANGE);
    }

    /**
     * 绑定交换机
     * @return
     */
    @Bean
    public Binding bindingFanout(){
        return BindingBuilder.bind(createFanoutQueue()).to(defFanoutExchange());
    }
}
