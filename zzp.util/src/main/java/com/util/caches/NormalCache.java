package com.util.caches;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 非超时缓存
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class NormalCache extends Cache<String, Object>{

//    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    protected boolean cacheValid(Object value) {
        return value != null;
    }

//    @Override
//    protected Object getValue(String key) {
//        return key + "-" + atomicInteger.incrementAndGet();
//    }
}
