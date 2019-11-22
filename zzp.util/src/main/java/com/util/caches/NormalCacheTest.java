package com.util.caches;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @Description 非超时缓存测试
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class NormalCacheTest {

    public static void main(String[] args) {
        Cache<String, Object> cache = new NormalCache();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    String key = "TEST-A";
                    String value = (String) cache.get(key);
                    String nowDateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                    System.out.println(nowDateStr + " -- " + Thread.currentThread().getName() + " -- key:" + key + ",value:" + value);
                    try {
                        Thread.sleep(6 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    String key = "TEST-A";
                    String value = (String) cache.get(key);
                    String nowDateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                    System.out.println(nowDateStr + " -- " + Thread.currentThread().getName() + " -- key:" + key + ",value:" + value);
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

    }

}
