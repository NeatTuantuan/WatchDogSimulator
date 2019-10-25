package HttpSimulator;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;
import util.EntityInit;
import util.ImageUtil;

/**
 * @ClassName HeartbeatClient
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/10/9 10:54
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class HeartbeatClient implements Runnable{
    private String host;
    private int port;
    private EntityInit entityInit;

    public HeartbeatClient(String host, int port,EntityInit entityInit){
        this.host = host;
        this.port = port;
        this.entityInit = entityInit;
    }

    @Override
    public void run() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        io.netty.bootstrap.Bootstrap b = new io.netty.bootstrap.Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.option(ChannelOption.SO_KEEPALIVE,true);

        HeartBeatServerHandler heartBeatServerHandler = new HeartBeatServerHandler();
        heartBeatServerHandler.setEntityInit(this.entityInit);

        b.handler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new HttpRequestEncoder());
                ch.pipeline().addLast(heartBeatServerHandler);
            }
        });

        ChannelFuture f = b.connect(host,port);
        try {
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
