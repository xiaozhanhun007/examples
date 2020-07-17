package com.zzp.etl.task;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description ETL任务抽象类
 * @Author Garyzeng
 * @since 2020.07.17
 **/
public abstract class EtlTask {

    private List<EtlTaskListener> listeners;

    public EtlTask() {
        listeners = new LinkedList<EtlTaskListener>();
    }

    public void addListener(EtlTaskListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public abstract void beforeRun();

    public abstract void afterRun();

    public void run() {
        this.beforeRun();
        for (EtlTaskListener listener : listeners) {
            listener.save(listener.count());
        }
        this.afterRun();
    }

}
