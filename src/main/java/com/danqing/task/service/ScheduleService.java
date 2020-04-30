package com.danqing.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author 丹青
 * @date 2020/4/24-12:09
 */
@Service
public class ScheduleService {
    /**
     * second, minute, hour, day of month（日）, month, and day of week（周）.
     * 【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     *  【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
     *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     */
    //@Scheduled(cron = "0 * * * * MON-SAT")//周一到周六每分钟打印一次
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")//周一到周六每分钟的第1,2,3,4,5秒打印一次
    //@Scheduled(cron = "0-4 * * * * MON-SAT")//周一到周六每分钟的第1,2,3,4,5秒打印一次
    @Scheduled(cron = "0/4 * * * * MON-SAT")//从1秒启动，每4秒执行一次

    public void hello(){
        System.out.println("hello......");
    }
}
