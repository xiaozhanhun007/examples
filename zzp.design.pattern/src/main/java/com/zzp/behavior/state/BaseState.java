package com.zzp.behavior.state;

/**
 * @Description 状态抽象类
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public abstract class BaseState {

    protected Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void doAction();
}
