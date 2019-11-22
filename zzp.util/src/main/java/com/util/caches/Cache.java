package com.util.caches;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 缓存模板，使用读写锁实现的缓存
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public abstract class Cache<K, V> {

    private final Map<K, V> m = new HashMap<K, V>();

    private final ReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock readLock = rwl.readLock();

    private final Lock writeLock = rwl.writeLock();

    public V get(K key){
        // 获取读锁
        readLock.lock();
        V value = m.get(key);
        if (!cacheValid(value)) {
            // 释放读锁，因为不允许读锁升级为写锁
            readLock.unlock();
            // 获取写锁
            writeLock.lock();
            try {
                // 再次检查状态，防止多线程的访问的时候，重复put值
                if (!cacheValid(value)) {
                    // put值
                    V newValue = getValue(key);
                    m.put(key, newValue);
                    value = newValue;
                }
                // 释放写锁前，降级为读锁
                readLock.lock();
            } finally {
                // 释放写锁
                writeLock.unlock();
            }
        }

        // 此时还拥有读锁
        try {
            return value;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 对缓存的校验，需要由子类实现
     * @param value
     * @return
     */
    protected abstract boolean cacheValid(V value);

    /**
     * 获取Value，需要由子类实现
     * @param key
     * @return
     */
    protected abstract V getValue(K key);

}
