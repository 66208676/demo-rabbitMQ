package com.example.demo.controller;

import com.example.demo.mq.TestCustomer;
import com.example.demo.mq.TestProduct;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/5/30 18:38
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    private static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestProduct testProduct;
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/sendTest")
    public String sendTest(){
        System.out.println("===sendTest==");
        testProduct.sendFanoutQueue("测试消息");
        return "SUCCESS";
    }

    @RequestMapping(value = "/addOrder")
    public String addOrder(int num){
        System.out.println("===addOrder==");
        try {
            if(StringUtils.isEmpty(num)){
                return "faild";
            }
            String s = orderService.addOrder(num);
            LOGGER.info("返回",s);
        } catch (Exception e) {
            e.printStackTrace();
            return "异常";
        }
        return "SUCCESS";
    }

}
