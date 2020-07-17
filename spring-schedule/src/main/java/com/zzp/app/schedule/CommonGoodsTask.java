package com.zzp.app.schedule;

import com.zzp.app.vo.User;
import com.zzp.etl.task.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description 公共商品库定时任务
 * @Author Garyzeng
 * @since 2020.07.17
 **/
@Component
@PropertySource(value={"classpath:jobs.properties"})
public class CommonGoodsTask extends EtlTask{

    /**
     * 使用@Qualifier注解可以指定注入bean的名称
     */
    @Autowired
    @Qualifier("commonGoodsScpAdapter")
    private EtlTaskListener<User> scpAdapter;

    @Autowired
    @Qualifier("commonGoodsScmAdapter")
    private EtlTaskListener<User> scmAdapter;

    @Value("${jobs.schedule.commonGoods.enable}")
    private Boolean enable = true;

    @Scheduled(cron = "${jobs.schedule.commonGoods}")
    public void start(){
        if (!enable) {
            System.out.println("公共商品库定时任务未开启");
            return;
        }

        this.run();
    }

    @Override
    public void beforeRun() {
        System.out.println("公共商品库定时任务开始");
    }

    @Override
    public void afterRun() {
        System.out.println("公共商品库定时任务结束");
    }

    /**
     * bean初始化完之后调用的方法
     */
    @PostConstruct
    public void initMethod() {
        this.addListener(scpAdapter);
        this.addListener(scmAdapter);
    }

    /**
     * bean销毁之前调用的方法
     */
    @PreDestroy
    public void destoryMethod() {
        System.out.println("公共商品库定时任务销毁了");
    }


}
