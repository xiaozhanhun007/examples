package com.zzp.behavior.state;

/**
 * @Description 检查状态
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class CheckState extends BaseState {

    @Override
    public void doAction() {
        this.context.setState(this);
        System.out.println("当前状态是审核，下一步是复审");
    }
}
