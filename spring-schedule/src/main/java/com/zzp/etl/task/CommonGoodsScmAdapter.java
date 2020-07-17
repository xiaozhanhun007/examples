package com.zzp.etl.task;

import com.zzp.app.vo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description ETL公共商品库SCM适配器
 * @Author Garyzeng
 * @since 2020.07.17
 **/
@Component(value = "commonGoodsScmAdapter")
public class CommonGoodsScmAdapter implements EtlTaskListener<User>{

    @Override
    public void save(List<User> list) {
        System.out.println("保存SCM数据");
    }

    @Override
    public List<User> count() {
        System.out.println("汇总SCM数据");
        return null;
    }
}
