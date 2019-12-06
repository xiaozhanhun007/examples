package com.zzp.behavior.state;

/**
 * @Description 完成状态
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class FinishState extends BaseState {

    @Override
    public void doAction() {
        this.context.setState(this);
        System.out.println("流程已完成");
    }
}
