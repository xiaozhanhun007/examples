package com.zzp.netty.server.handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description DiscardServerHandler
 * @Author Garyzeng
 * @since 2019.12.31
 **/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String m = (String) msg;
        System.out.println("服务器接收到的数据：" + m);
        ctx.writeAndFlush("服务器已收到：" + m);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel());
        ctx.writeAndFlush("yes");
    }



}
