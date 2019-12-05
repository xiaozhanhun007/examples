package com.zzp.behavior.responsibility.chain;

/**
 * @Description url超时handler
 * @Author Garyzeng
 * @since 2019.12.05
 **/
public class UrlTimeOutHandler extends Handler {

    @Override
    public void apply(Context context) {
        UrlContext urlContext = (UrlContext) context;
        long nowTime = System.currentTimeMillis();
        if (nowTime - urlContext.getCreateTime().getTime() > 1000 * 60 * 60) {
            throw new RuntimeException("时间已经超过有效期！");
        }
        if (this.nextHandler != null) {
            this.nextHandler.apply(context);
        }
    }
}
