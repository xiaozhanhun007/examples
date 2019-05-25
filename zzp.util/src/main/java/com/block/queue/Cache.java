package com.block.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.05.17
 **/
public class Cache<K, V> {

    private final Map<K, V> m = new HashMap<K, V>();

    private final ReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock readLock = rwl.readLock();

    private final Lock writeLock = rwl.writeLock();

    public V get(){
        return null;
    }

}
