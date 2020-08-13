package com.example.demo.common;

/**
 * @author ZQ
 * @version 1.0
 * @Description
 * @date 2020/8/13 14:26
 */
public class BaseException extends RuntimeException{
    public BaseException(){
        super();
    }
    public BaseException(String msg){
        super(msg);
    }

    public BaseException(Throwable cause){
        super(cause);
    }

    public BaseException(String msg, Throwable cause){
        super(msg, cause);
    }
}
