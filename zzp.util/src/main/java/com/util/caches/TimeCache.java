package com.util.caches;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 超时缓存
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class TimeCache extends Cache<String, TimeValue> {

    private final long effectiveTime = 30 * 1000;// 缓存有效时间长度，单位毫秒

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    protected boolean cacheValid(TimeValue value) {
        if (value != null) {
            long nowTime = System.currentTimeMillis();
            return nowTime - value.getTimestamp() <= effectiveTime;
        }
        return false;
    }

    @Override
    protected TimeValue getValue(String key) {
        TimeValue timeValue = new TimeValue();
        List<String> list = new ArrayList<String>();
        list.add(key + "-" + atomicInteger.incrementAndGet());
        timeValue.setList(list);
        timeValue.setTimestamp(System.currentTimeMillis());
        return timeValue;
    }
}
