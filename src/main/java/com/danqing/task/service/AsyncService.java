package com.danqing.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 丹青
 * @date 2020/4/24-11:19
 */
@Service
public class AsyncService {

    @Async//告诉Spring这是一个异步方法
    public void hello(){
        try {//模拟同步处理数据消耗3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中......");
    }
}
