package com.zzp.netty.client;

/**
 * @Description netty客户端测试
 * @Author Garyzeng
 * @since 2020.01.01
 **/
public class Test {

    public static void main(String[] args) {
        NettyClient client = new NettyClient("127.0.0.1", 8080);
        client.run();
        client.send("aaa");
    }

}
