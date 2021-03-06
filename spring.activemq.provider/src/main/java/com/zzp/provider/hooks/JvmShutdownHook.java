package com.zzp.provider.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description JvmShutdownHook
 * @Author karyzeng
 * @since 2020.07.07
 **/
public class JvmShutdownHook extends Thread{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("调用JvmShutdownHook");
    }
}
