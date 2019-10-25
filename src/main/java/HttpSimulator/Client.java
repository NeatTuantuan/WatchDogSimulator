//package HttpSimulator;
//
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.http.*;
//import swing.Example;
//import util.ImageUtil;
//
///**
// * @ClassName Client
// * @Description TODO
// * @Auther tuantuan
// * @Date 2019/9/18 11:06
// * @Version 1.0
// * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
// **/
//public class Client implements Runnable{
//    private String host;
//    private int port;
//    private ChannelInboundHandlerAdapter channelInboundHandlerAdapter;
//
//    public Client(String host, int port, ChannelInboundHandlerAdapter channelInboundHandlerAdapter){
//        this.host = host;
//        this.port = port;
//        this.channelInboundHandlerAdapter = channelInboundHandlerAdapter;
//    }
//
//    @Override
//    public void run() {
//        ImageUtil imageUtil = new ImageUtil();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        io.netty.bootstrap.Bootstrap b = new io.netty.bootstrap.Bootstrap();
//        b.group(workerGroup);
//        b.channel(NioSocketChannel.class);
//        b.option(ChannelOption.SO_KEEPALIVE,true);
//        b.handler(new ChannelInitializer() {
//            @Override
//            protected void initChannel(Channel ch) throws Exception {
//                ch.pipeline().addLast(new HttpRequestEncoder());
////                ch.pipeline().addLast(new HeartBeatServerHandler());
//                ch.pipeline().addLast(channelInboundHandlerAdapter);
//            }
//        });
//
//        ChannelFuture f = b.connect(host,port);
//        try {
//            f.channel().closeFuture().sync();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            workerGroup.shutdownGracefully();
//        }
//    }
//
//
//    public static void main(String[] args){
//        Client client = new Client("127.0.0.1",8080,new HeartBeatServerHandler());
//        Client client1 = new Client("127.0.0.1",8080,new EntityServerHandler());
//        new Thread(client).start();
//        new Thread(client1).start();
//
////        Example example = new Example();
////        example.start();
//    }
//
//}
