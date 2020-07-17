package com.zzp.etl.task;

import com.zzp.app.vo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description ETL公共商品库SCP适配器
 * @Author Garyzeng
 * @since 2020.07.17
 **/
@Component(value = "commonGoodsScpAdapter")
public class CommonGoodsScpAdapter implements EtlTaskListener<User>{

    @Override
    public void save(List<User> list) {
        System.out.println("保存SCP数据");
    }

    @Override
    public List<User> count() {
        System.out.println("汇总SCP数据");
        return null;
    }
}
