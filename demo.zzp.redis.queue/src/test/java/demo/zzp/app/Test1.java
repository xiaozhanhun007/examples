package demo.zzp.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.zzp.app.Application;
import demo.zzp.app.redis.RedisQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class Test1 {
	
	@Autowired
	private RedisQueue redisQueue;
	
	@Test
	public void test1() {
		String key = "C11223";
		String number = redisQueue.getNumber(key, 3);
		System.out.println(Thread.currentThread().getName() + ":" + number);
		NumberThread numberThread = new NumberThread(redisQueue, key, 4);
		Thread thread1 = new Thread(numberThread);
		Thread thread2 = new Thread(numberThread);
		Thread thread3 = new Thread(numberThread);
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
