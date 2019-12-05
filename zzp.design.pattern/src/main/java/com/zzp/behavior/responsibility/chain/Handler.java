package com.zzp.behavior.responsibility.chain;

/**
 * @Description handler抽象类
 * @Author Garyzeng
 * @since 2019.12.05
 **/
public abstract class Handler {

    protected Handler nextHandler;

    public abstract void apply(Context context);

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
