package com.util.caches;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 超时缓存value
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class TimeValue implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 内容
     */
    private List<String> list;

    /**
     * 创建该缓存的时间戳
     */
    private Long timestamp;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
