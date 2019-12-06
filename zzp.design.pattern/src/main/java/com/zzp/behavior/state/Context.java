package com.zzp.behavior.state;

/**
 * @Description 上下文context
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class Context {

    private BaseState state;

    public BaseState getState() {
        return state;
    }

    public void setState(BaseState state) {
        this.state = state;
        this.state.setContext(this);
    }

    public void doSomething() {
        this.state.doAction();
    }
}
