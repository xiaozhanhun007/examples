package com.zzp.base.mq.msg.vo;

import java.io.Serializable;

/**
 * @Description MQ传输对象
 * @Author Garyzeng
 * @since 2019.12.07
 **/
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;

    private T data;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
