package demo.zzp.app.redis;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis队列工具类
 * @author zzp 2018.04.04
 */
@Component
public class RedisQueue {
	
	@Autowired
	private JedisConfig jedisConfig;
	
	private JedisPool getJedisPool(){
		return jedisConfig.redisPoolFactory();
	}
	
	/**
	 * 将当天的日期格式化成字符串
	 * @param dateFormat 日期格式
	 * @return
	 */
	private String formatDate(String dateFormat) {
		String rtn = "";
		if (dateFormat != null && dateFormat.trim().length() > 0) {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			rtn = format.format(new Date());
		}
		return rtn;
	}
	
	/**
	 * 给key的value加1
	 * @param key
	 */
	private long next(String key) {
		JedisPool jedisPool = getJedisPool();
    	//从连接池获取连接  
    	Jedis jedis = null;  
    	try{  
    	   jedis = jedisPool.getResource();  
    	   long number = jedis.incr(key);
    	   return number;
    	}catch(Exception e) {  
    	   e.printStackTrace(); 
    	   return -1;
    	}finally{  
    	   //归还连接到redis池中  
    		jedis.close();
    	} 
	}
	
	/**
	 * 给key对应的value加1，并且返回前缀为日期+number的字符串
	 * @param key
	 * @param numberLength
	 * @return 返回字符串，格式如2018040400001
	 */
	public String getNumber(String key,int numberLength) {
		String dateStr = formatDate("yyyyMMdd");
		String number = dateStr + StringUtils.leftPad(String.valueOf(next(key)), numberLength, "0");
		return number;
	}
	
}
