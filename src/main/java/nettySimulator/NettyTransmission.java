package nettySimulator;

import entity.Record;
import entity.Status;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import util.ImageUtil;
import util.ParseJson;

/**
 * @ClassName NettyTransmission
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/10 20:26
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class NettyTransmission {
    static ImageUtil imageUtil = new ImageUtil();
    public static void main(String[] args){
        Bootstrap client = new Bootstrap();
        ParseJson parseJson = new ParseJson();

        EventLoopGroup group = new NioEventLoopGroup();
        client.group(group);

        client.channel(NioSocketChannel.class);

        client.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
//                nioSocketChannel.pipeline().addLast(new StringDecoder());
//                nioSocketChannel.pipeline().addLast(new StringEncoder());
                nioSocketChannel.pipeline().addLast(new MyEncoder());
//                nioSocketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
            }
        });

        try {
            //连接至服务器
            ChannelFuture future = client.connect("127.0.0.1",8080).sync();

//            while(true){
                future.channel().writeAndFlush(parseJson.Object2Json(new Status()));
                Thread.sleep(2000);
//            }
            future.channel().closeFuture().sync();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
