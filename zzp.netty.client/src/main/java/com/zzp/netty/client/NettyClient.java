package com.zzp.netty.client;

import com.zzp.netty.client.handlers.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description netty客户端
 * @Author Garyzeng
 * @since 2020.01.01
 **/
public class NettyClient {

    private String host;

    private Integer port;

    private EventLoopGroup workerGroup;

    private Bootstrap b;

    private ChannelFuture future;

    public NettyClient() {}

    public NettyClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    private void doOpen() {
        workerGroup = new NioEventLoopGroup();
        try {
            b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline()
                            .addLast(new StringDecoder())
                            .addLast(new StringEncoder())
                            .addLast(new ClientHandler());
                }

            });
            future = b.connect(host, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            workerGroup.shutdownGracefully();
        }


    }

    public void send(Object msg) {
        future.channel().writeAndFlush(msg);
        System.out.println("客户端发送消息完毕");
    }

    private void close() {
        try {
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.doOpen();
    }

}
