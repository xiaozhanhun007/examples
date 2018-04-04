package demo.zzp.app;

import demo.zzp.app.redis.RedisQueue;

public class NumberThread implements Runnable {

	private RedisQueue redisQueue;
	private String key;
	private int numberLength;
	
	@Override
	public void run() {
		String number = redisQueue.getNumber(key, numberLength);
		System.out.println(Thread.currentThread().getName() + ":" + number);

	}
	
	public NumberThread(RedisQueue redisQueue,String key,int numberLength) {
		this.redisQueue = redisQueue;
		this.key = key;
		this.numberLength = numberLength;
	}

}
