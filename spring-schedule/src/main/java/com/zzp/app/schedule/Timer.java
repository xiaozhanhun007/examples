package com.zzp.app.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * 
 * @author Gary Zeng
 * @since 2018.07.10
 */
@Component
public class Timer {

//	@Scheduled(cron = "0/5 * * * * *")
	public void timer1() {
		System.out.println("执行一次定时任务！");
	}
	
}
