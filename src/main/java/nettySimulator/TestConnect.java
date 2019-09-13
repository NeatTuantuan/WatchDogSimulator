package nettySimulator;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import nettySimulator.ServervHandler;

/**
 * @ClassName nettySimulator.TestConnect
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/11 9:33
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class TestConnect  {
    public static void main(String[] args){
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        serverBootstrap.group(bossGroup,workerGroup);

        serverBootstrap.option(ChannelOption.SO_BACKLOG,128);
        serverBootstrap.channel(NioServerSocketChannel.class);

        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
//                socketChannel.pipeline().addLast(new StringDecoder());
                socketChannel.pipeline().addLast(new MyDecoder());
                socketChannel.pipeline().addLast(new ServervHandler());
            }

        });
        try {
            ChannelFuture future = serverBootstrap.bind(8080).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
