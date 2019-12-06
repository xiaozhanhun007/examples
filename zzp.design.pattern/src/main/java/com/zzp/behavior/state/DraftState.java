package com.zzp.behavior.state;

/**
 * @Description 草稿状态
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class DraftState extends BaseState {

    @Override
    public void doAction() {
        this.context.setState(this);
        System.out.println("当前状态是草稿，下一步是审核");
    }
}
