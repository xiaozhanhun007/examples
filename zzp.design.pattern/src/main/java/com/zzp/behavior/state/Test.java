package com.zzp.behavior.state;

/**
 * @Description 状态模式测试
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class Test {

    public static void main(String[] args) {
        // 创建一个上下文
        Context context = new Context();

        // 草稿状态
        BaseState draft = new DraftState();
        context.setState(draft);
        context.doSomething();

        // 审核状态
        BaseState check = new CheckState();
        context.setState(check);
        context.doSomething();

        // 复审状态
        BaseState doubleCheck = new DoubleCheckState();
        context.setState(doubleCheck);
        context.doSomething();

        // 完成状态
        BaseState finish = new FinishState();
        context.setState(finish);
        context.doSomething();
    }

}
