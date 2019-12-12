package com.zzp.provider.timing.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description 发送消息到mq的定时任务
 * @author Garyzeng
 * @since 2019.12.13
 **/
@Component
public class SendMessageTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        logger.info("发送消息到mq任务开始");
        logger.info("发送消息到mq任务结束");
    }

}
