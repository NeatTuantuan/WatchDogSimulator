package HttpSimulator;

import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestEncoder;

/**
 * @ClassName EntityClient
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/10/9 11:03
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class EntityClient implements Runnable{
    private String host;
    private int port;
    private int entityType = -1;
    /**
     * 构造方法，初始化参数
     * @param host
     * @param port
     * @param entityType 发送消息种类0：开门记录 1：抓拍照片
     */
    public EntityClient(String host, int port, int entityType){
        this.host = host;
        this.port = port;
        this.entityType = entityType;
    }

    /**
     * 重写线程run方法
     */
    @Override
    public void run() {
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            io.netty.bootstrap.Bootstrap b = new io.netty.bootstrap.Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE,true);

            b.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    if (entityType == 0){
                        ch.pipeline().addLast(new RecordServerHandler());
                    }else if (entityType == 1){
                        ch.pipeline().addLast(new PhotoUploadServerHandler());
                    }else {
                        System.out.println("类型错误");
                    }

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
