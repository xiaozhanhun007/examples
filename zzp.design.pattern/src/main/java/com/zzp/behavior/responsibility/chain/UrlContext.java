package com.zzp.behavior.responsibility.chain;

import java.util.Date;

/**
 * @Description url context实现类
 * @Author Garyzeng
 * @since 2019.12.05
 **/
public class UrlContext implements Context{

    private String url;

    private Date createTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
