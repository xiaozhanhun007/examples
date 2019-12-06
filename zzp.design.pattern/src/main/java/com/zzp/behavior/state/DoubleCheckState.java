package com.zzp.behavior.state;

/**
 * @Description 复审状态
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class DoubleCheckState extends BaseState {

    @Override
    public void doAction() {
        this.context.setState(this);
        System.out.println("当前状态是复审，下一步是完成");
    }
}
