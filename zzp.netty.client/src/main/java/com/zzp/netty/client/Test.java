package com.zzp.netty.client;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description netty客户端测试
 * @Author Garyzeng
 * @since 2020.01.01
 **/
public class Test {

    public static void main(String[] args) {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        client.run();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("name", "金甲卡卡龙");

        String msg = JSON.toJSONString(map);

        client.send(msg);

        map.put("id", 2);
        map.put("name", "保温杯");

        client.send(JSON.toJSONString(map));

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        client.close();
    }

}
