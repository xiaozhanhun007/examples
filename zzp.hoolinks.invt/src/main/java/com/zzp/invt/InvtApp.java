package com.zzp.invt;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description 启动类
 * @Author Garyzeng
 * @since 2019.12.03
 **/
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)// 配置多个数据源需要关闭自动配置数据源
@ComponentScan(basePackages={"com.zzp"})
@EnableScheduling
@MapperScan("com.zzp.**.mapper")
@PropertySource(value={"classpath:constants.properties"})
public class InvtApp {

    public static void main(String[] args) {
        SpringApplication.run(InvtApp.class, args);
    }

}
