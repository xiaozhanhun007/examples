package com.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkerThreadPool {

	public static void main(String[] args) {
		ThreadPoolExecutor workPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		
		while (true) {
			for (int i = 0; i < 5; i++) {
				WorkerThread workerThread = new WorkerThread("任务" + (i + 1));
				workPool.execute(workerThread);
				System.out.println("线程池中线程数目："+workPool.getPoolSize()+"，队列中等待执行的任务数目："+workPool.getQueue().size()+"，已执行玩别的任务数目："+workPool.getCompletedTaskCount());
			}
			System.out.println("-----------");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
