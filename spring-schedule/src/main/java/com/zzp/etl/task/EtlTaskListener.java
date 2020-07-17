package com.zzp.etl.task;

import java.util.List;

/**
 * @Description ETL任务抽象接口
 * @Author Garyzeng
 * @since 2020.07.17
 **/
public interface EtlTaskListener<T> {

    void save(List<T> list);

    List<T> count();

}
