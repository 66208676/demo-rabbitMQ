package com.example.demo.service.impl;

import com.example.demo.common.BaseException;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/13 13:36
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    @Retryable(value = Exception.class,exclude = BaseException.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public String addOrder(int num) throws Exception {
        LOGGER.info("=====请求===={}",System.currentTimeMillis());
        if(num > 10){
            throw new RuntimeException("操作失败");
        }else if(num >5 && num <10){
            throw new Exception("异常2");
        }else if(num >1 && num <5){
            throw new BaseException("异常3");
        }
        LOGGER.info("=====请求end===={}",System.currentTimeMillis());
        return "success";
    }
}
