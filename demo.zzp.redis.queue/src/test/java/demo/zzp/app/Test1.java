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
		System.out.println(redisQueue.getNumber(key, 4));
	}

}
